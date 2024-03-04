package org.startup.diabetes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass //BaseEntity를 상속한 엔티티들은 아래 필드를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class) //Auditing(자동으로 값 매핑)기능 추가
abstract class BaseEntity {

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime modDate;

}
