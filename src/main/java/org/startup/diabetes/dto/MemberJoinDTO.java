package org.startup.diabetes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinDTO {

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
    private String userid;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 4, max = 10, message = "비밀번호는 4자 이상 10자 이하로 입력해주세요.")
    private String pw;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "나이를 입력해주세요.")
    private int age;

    @NotBlank(message = "성별을 입력해주세요.")
    private String gender;

    @NotBlank(message = "키를 입력해주세요.")
    private int tall;

    @NotBlank(message = "몸무게를 입력해주세요.")
    private int weight;
}
