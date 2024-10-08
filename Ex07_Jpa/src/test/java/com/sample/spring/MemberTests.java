package com.sample.spring;

import com.sample.spring.domain.Member;
import com.sample.spring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class MemberTests {
    @Autowired
    private MemberRepository repo;

    @Test
    public void testinsert() {
        for (int i=1; i<=5; i++) { // 100개의 데이터 들어감..
            Member member = Member.builder()
                    .createDate(LocalDate.now())
                    .name("test")
                    .email("zlnongi@test.com")
                    .build();
            repo.save(member);
        }
    }


}
