package org.startup.diabetes.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
                                    // User Details를 상속받아 인증 객체로 사용

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer tall;

    @Column(nullable = false)
    private Integer weight;






    public void change(String pw, String name, Integer age, String gender, Integer tall, Integer weight){

        this.pw = pw;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.tall = tall;
        this.weight = weight;
    }



}
