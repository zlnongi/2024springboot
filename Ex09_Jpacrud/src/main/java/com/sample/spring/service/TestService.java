package com.sample.spring.service;

import com.sample.spring.entity.TestEntity;
import com.sample.spring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    // 레포지토리 연결시켜서 거기서 메소드들 가져옴
    @Autowired
    private TestRepository testRepository;

    public void create(String name, Integer age) { // 이름과 age 필요
        TestEntity testEntity = new TestEntity(name, age); // TestEntity type으로 만들어준 것
        testRepository.save(testEntity); // 그거에다 저장해줌
    }

    public void update(Long id, String name, Integer age) {
        TestEntity testEntity = testRepository.findById(id).get(); // 아이디 값을 찾은 다음에 있냐 없냐 확인??
        testEntity.changeNameAndAge(name, age); // change된 데이터
        testRepository.save(testEntity); // 저장하기
    }

    public void delete(Long id) {
        TestEntity testEntity = testRepository.findById(id).get(); // optional이라서 get으로
        testRepository.delete(testEntity);

    }

    public List<TestEntity> findAll() { // 내가 그냥 만든 것
        return testRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
