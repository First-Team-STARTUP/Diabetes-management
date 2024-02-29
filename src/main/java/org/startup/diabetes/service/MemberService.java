package org.startup.diabetes.service;

import org.startup.diabetes.dto.MemberJoinDTO;


public interface MemberService {


    static class MidExistException extends Exception {}

    public String join(MemberJoinDTO dto) throws MidExistException;

}
