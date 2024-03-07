package org.startup.diabetes.service;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.startup.diabetes.domain.Board;
import org.startup.diabetes.domain.Fasting;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.MemberDTO;
import org.startup.diabetes.dto.MemberPwUpdateDTO;
import org.startup.diabetes.repository.BoardRepository;
import org.startup.diabetes.repository.FastingRepository;
import org.startup.diabetes.repository.MemberRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
@Builder
@Transactional
public class MemberServiceImpl implements MemberService {


    private final FastingRepository fastingRepository;

    private final MemberRepository memberRepository;

    private final BoardRepository boardRepository;

    private final ModelMapper modelMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String join(MemberDTO dto) throws MidExistException {

        String userid = dto.getUserid();

        if(checkUseridDuplicate(userid)){
            throw new MidExistException();

        }
        Member member = modelMapper.map(dto, Member.class);
        // 비밀번호 암호화
        member.setPw(passwordEncoder.encode(dto.getPw()));
        // Member 엔티티 저장
        return memberRepository.save(member).getUserid();
    }


    @Override
    public boolean checkUseridDuplicate(String userid) {
        Optional<Member> existMember = memberRepository.findByUserid(userid);

        return existMember.isPresent();
    }


    @Override
    public MemberDTO readMyPage(String userid) {

        if (userid == null || userid.isEmpty()) {
            throw new IllegalArgumentException("UserID must not be null or empty");
        }

        Optional<Member> result = memberRepository.findByUserid(userid);

        Member member = result.orElseThrow(() -> new IllegalArgumentException("User not found with UserID: " + userid));

        MemberDTO dto = entityToDTO(member);
        // 나머지 필드도 동일하게 설정

        return dto;
    }


    @Override
    public void modifyUser(MemberDTO memberDTO) {
        Optional<Member> result = memberRepository.findByUserid(memberDTO.getUserid());

        Member member = result.orElseThrow(() -> new NoSuchElementException("해당하는 회원을 찾을 수 없습니다."));

        member.change(
                memberDTO.getName(),
                memberDTO.getAge(),
                memberDTO.getGender(),
                memberDTO.getTall(),
                memberDTO.getWeight());


        memberRepository.save(member);
    }

    @Override
    public String removeUser(@Valid MemberDTO memberDTO, UserDetails userDetails) {

        Optional<Member> member = memberRepository.findByUserid(userDetails.getUsername());
        member.ifPresent(memberData -> {
            // 해당 유저의 정보를 삭제하기 전에 fasting 테이블에서 관련된 데이터를 삭제
            List<Fasting> fastingList = fastingRepository.findByMemberUserid(memberData.getUserid());
            List<Board> boardList = boardRepository.findByMemberUserid(memberData.getUserid());
            if (!fastingList.isEmpty()) {
                fastingRepository.deleteAll(fastingList);
                boardRepository.deleteAll(boardList);
            }
            // 회원 정보 삭제
            memberRepository.delete(memberData);
        });
        return null;
    }


    @Override
    public String changePassword(MemberPwUpdateDTO dto, String userid) {

        Member member = memberRepository.findByUserid(userid)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));


        if(!passwordEncoder.matches(dto.getPw(), member.getPw())){
            return null;
        } else {
            dto.setNewPw(passwordEncoder.encode(dto.getNewPw()));
            member.updatePassword(dto.getNewPw());
            memberRepository.save(member);
        }
        return member.getUserid();


    }

}
