package org.startup.diabetes.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.startup.diabetes.dto.MemberJoinDTO;

import java.util.Map;

public interface MemberService {


    static class MidExistException extends Exception {}

    public String join(MemberJoinDTO dto) throws MidExistException;

    public boolean checkUseridDuplicate(String userid);



//    public Map<String, String> validateHandling(Errors errors);

}
