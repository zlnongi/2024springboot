package com.sample.spring.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="test1")

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100)
    private String name;

    @Column(name="uemail")
    private String email;
    private LocalDate createDate;

}
