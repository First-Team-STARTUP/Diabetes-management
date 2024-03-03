package org.startup.diabetes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {


    private Long id;

    private String userid;

    private String pw;

    private String name;

    private int age;

    private String gender;

    private int tall;

    private int weight;
}
