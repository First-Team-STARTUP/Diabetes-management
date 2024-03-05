package org.startup.diabetes.service;

import lombok.extern.log4j.Log4j2;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.MemberDTO;

import java.util.List;
import java.util.stream.Collectors;


public interface MemberService {


    static class MidExistException extends Exception {

    }

    public String join(MemberDTO dto) throws MidExistException;

    public boolean checkUseridDuplicate(String userid);

    public MemberDTO readMyPage(String userid);

//    public Map<String, String> validateHandling(Errors errors);

    public void modifyUser(MemberDTO memberDTO);

    public void removeUser(String userid);

    default MemberDTO entityToDTO(Member member) {

        MemberDTO dto = MemberDTO.builder()
                .userid(member.getUserid())
                .pw(member.getPw())
                .name(member.getName())
                .age(member.getAge())
                .gender(member.getGender())
                .tall(member.getTall())
                .weight(member.getWeight())
                .build();

        return dto;
    }

}
