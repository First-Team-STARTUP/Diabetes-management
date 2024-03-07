package org.startup.diabetes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberPwUpdateDTO {

    private Long id;
    private String userid;
    private String pw;
    private String newPw;
    private String ConfirmPw;


}
