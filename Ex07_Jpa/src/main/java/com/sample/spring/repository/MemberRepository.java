package com.sample.spring.repository;

import com.sample.spring.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> { // repo는 하나의 테이블 엮어서 씀 (현재는 member table)
    // crud 자동생성
    Page<Member> findMemberByName(String keyword, Pageable pageable);
}
