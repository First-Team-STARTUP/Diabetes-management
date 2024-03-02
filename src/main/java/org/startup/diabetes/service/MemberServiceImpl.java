package org.startup.diabetes.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.MemberJoinDTO;
import org.startup.diabetes.repository.MemberRepository;

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
    public String join(MemberJoinDTO dto) throws MidExistException {

        String userid = dto.getUserid();

        if(checkUseridDuplicate(userid)){
            throw new MidExistException();
        }

        Member member = modelMapper.map(dto, Member.class);

        // 비밀번호 암호화
        member.setPw(passwordEncoder.encode(dto.getPw()));
        // Member 엔티티 저장
        return memberRepository.save(member).getUserid();


//
//        Member member = modelMapper.map(memberJoinDTO, Member.class);
////        member.changePassword(passwordEncoder.encode(memberJoinDTO.getPw());
////        member.addRole(MemberRole.USER);
//
//        log.info("===================");
//        log.info(member);
//
//        memberRepository.save(member);
    }


    @Override
    public boolean checkUseridDuplicate(String userid) {
        Optional<Member> existMember = memberRepository.findByUserid(userid);

        return existMember.isPresent();
    }




}
