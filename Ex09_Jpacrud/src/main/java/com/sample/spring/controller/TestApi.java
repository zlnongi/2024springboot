package com.sample.spring.controller;

import com.sample.spring.entity.TestEntity;
import com.sample.spring.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController // api 사용 controller
public class TestApi {
    // test service 넣어줘야함 (주입)
    @Autowired
    private TestService testService;

    @GetMapping("/test/create") // test라는 요청이 들어오면
    public void createTest() {
        testService.create("zlnongi", 10); // 그냥 이거 바로 실행해줌
    }


    @PostMapping("/test/create")
    public void postCreate(@RequestBody CreateTestRequest request) { // @RequestBody로 받아서
        log.info("################"+request.getName());
        System.out.println("/-------------------"+request.getName()+"-------------------/");
        testService.create(request.getName(), request.getAge());
    }

    @PutMapping("/test/update") // /update?id=
    public void putUpdate( @RequestParam("id") Long id, @RequestBody CreateTestRequest request) { // id값 하나 받아서 dto
        testService.update(id, request.getName(), request.getAge());

    }

   // @DeleteMapping("/test/{id}/delete") -> localhost:8080/test/1/delete
    @DeleteMapping("test/delete") // localhost:8080/test/delete?id=1
    //public void deleteTest(@PathVariable("id") Long id)
    public void deleteTest(@RequestParam("id") Long id)
    {
        testService.delete(id); // id 값 받아서 testService의 delete
    }


   // @GetMapping("/test")
   // public List<TestEntity> jsonData() {
   //     return testService.findAll(); // 200 ok
   // }

    @GetMapping("/test")
    public ResponseEntity<List<TestEntity>> jsonData() {
        List<TestEntity> data = testService.findAll();
        return ResponseEntity.ok(data);
    }



    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class CreateTestRequest { // dto
        private String name;
        private Integer age;
    }


}