package org.startup.diabetes.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.MemberDTO;
import org.startup.diabetes.repository.MemberRepository;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
@Builder
@Transactional
public class MemberServiceImpl implements MemberService {



    private final MemberRepository memberRepository;

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
                memberDTO.getPw(),
                memberDTO.getName(),
                memberDTO.getAge(),
                memberDTO.getGender(),
                memberDTO.getTall(),
                memberDTO.getWeight());


        memberRepository.save(member);
    }

    @Override
    public void removeUser(String userid) {

        memberRepository.deleteById(userid);

    }
}
