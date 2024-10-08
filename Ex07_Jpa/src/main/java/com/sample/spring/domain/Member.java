package com.sample.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // null값 사용하지 않으므로 long 사용 가능

    @Column(length=100)
    private String name;


    private String email;
    private LocalDate createDate;

}
