package org.startup.diabetes.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.startup.diabetes.domain.Member;
import org.startup.diabetes.dto.MemberDTO;
import org.startup.diabetes.dto.MemberPwUpdateDTO;


public interface MemberService {


    static class MidExistException extends Exception {

    }

    public String join(MemberDTO dto) throws MidExistException;

    public boolean checkUseridDuplicate(String userid);

    public MemberDTO readMyPage(String userid);

//    public Map<String, String> validateHandling(Errors errors);

    public void modifyUser(MemberDTO memberDTO);

    public String removeUser(MemberDTO memberDTO, UserDetails userDetails);

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


    public String changePassword(MemberPwUpdateDTO dto, String userid) ;

}
