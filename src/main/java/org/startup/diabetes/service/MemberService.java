package org.startup.diabetes.service;

import org.startup.diabetes.dto.MemberJoinDTO;

public interface MemberService {
    Long join(MemberJoinDTO memberJoinDTO);

}
