package com.sample.spring.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sample.spring.model.TodoEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Querydsl

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {
    private final EntityManager em;

    @Bean
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(em);
    }
}
