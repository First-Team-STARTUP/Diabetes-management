package org.startup.diabetes.service;

import org.springframework.stereotype.Service;
import org.startup.diabetes.dto.MemberJoinDTO;

@Service
public interface MemberService {


    static class MidExistException extends Exception {}

    public String join(MemberJoinDTO dto) throws MidExistException;

    public Boolean checkUseridDuplicate(String userid);

}
