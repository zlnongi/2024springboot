package com.sample.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // 리본 생성자 생성 필수 어노테이션
@Entity
@Table(name="test")
public class TestEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    // name과 age 필드 초기화
    public TestEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // setter대신 change 사용하면 안정성이 있다
    // 객체의 이름과 나이를 변경시킬 때 사용 (값 변경)
    public void changeNameAndAge(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
