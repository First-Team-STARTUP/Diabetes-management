package org.startup.diabetes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginDTO {

    private Long id;

    private String userid;

    private String pw;

    private String name;

    private Integer age;

    private String gender;

    private Integer tall;

    private Integer weight;

}
