package org.startup.diabetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //엔티티가 데이터베이스에 추가되거나 변경될 때 자동으로 시간 값 지정
public class DiabetesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiabetesApplication.class, args);
    }

}
