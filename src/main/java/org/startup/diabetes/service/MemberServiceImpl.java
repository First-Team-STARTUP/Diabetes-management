package org.startup.diabetes.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.MemberJoinDTO;
import org.startup.diabetes.repository.MemberRepository;

@Log4j2
@Service
@RequiredArgsConstructor
@Builder

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    @Override
    public void join(MemberJoinDTO memberJoinDTO) throws MidExistException {


        String userId = memberJoinDTO.getUserid();

        boolean exist = memberRepository.existsById(userId);

        if(exist){
            throw new MidExistException();
        }




//        Member member = Member.builder
//                .userid(memberJoinDTO.getUserid())
//                .pw(memberJoinDTO.getPw())
//                .name(memberJoinDTO.getName())
//                .age(memberJoinDTO.getAge())
//                .gender(memberJoinDTO.getGender())
//                .tall(memberJoinDTO.getTall())
//                .weight(memberJoinDTO.getWeight())
//                .build();

        Member member = modelMapper.map(memberJoinDTO, Member.class);

//        member.changePassword(passwordEncoder.encode(memberJoinDTO.getPw());
//        member.addRole(MemberRole.USER);






        log.info("===================");
        log.info(member);


        memberRepository.save(member);
    }
}
