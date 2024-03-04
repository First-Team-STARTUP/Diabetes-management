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

    private int age;

    private String gender;

    private int tall;

    private int weight;

}
