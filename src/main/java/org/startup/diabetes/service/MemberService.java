package org.startup.diabetes.service;

import org.startup.diabetes.dto.MemberJoinDTO;

public interface MemberService {


    static class MidExistException extends Exception {}

    public String join(MemberJoinDTO dto) throws MidExistException;

    public boolean checkUseridDuplicate(String userid);



//    public Map<String, String> validateHandling(Errors errors);

}
