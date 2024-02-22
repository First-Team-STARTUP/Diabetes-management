package org.startup.diabetes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.MemberJoinDTO;
import org.startup.diabetes.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    public Long join(MemberJoinDTO memberJoinDTO) {
        Member member = Member.builder()
                .nickname(memberJoinDTO.getNickname())
                .pw(memberJoinDTO.getPw())
                .name(memberJoinDTO.getName())
                .age(memberJoinDTO.getAge())
                .gender(memberJoinDTO.getGender())
                .tall(memberJoinDTO.getTall())
                .weight(memberJoinDTO.getWeight())
                .build();

        return memberRepository.save(member).getId();
    }
}
