package org.startup.diabetes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinDTO {
    private String userid;

    private String pw;

    private String name;

    private int age;

    private String gender;

    private int tall;

    private int weight;
}
