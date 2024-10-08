package com.sample.spring.service;

import com.sample.spring.domain.Member;
import com.sample.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService { // DAO는 하나의 테이블 엮어서 씀 (현재는 repository)
    @Autowired
    private MemberRepository repo; // 갖고와서 이름 지어줌 + 주입하기

    public List<Member> selectAll() { // List로 넣어서 데이터 싹 다 가져옴
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id")); // id를 기준으로 sort
    }

    public Member insert (Member member) { // 데이터 저장 메서드
        Member returnMember = repo.save(member);
        return returnMember;
    }

    public Optional<Member> view(Long id) { // id 데이터 하나만 가져옴
        Optional<Member> member = repo.findById(id);
        return member;
    }

    public void delete(Long id) {
        repo.deleteById(id);

    }

    public Page<Member> selectNameLike(String search, Pageable pageable) {
        Page<Member> member = repo.findMemberByName(search, pageable);
        return member;
    }
}
