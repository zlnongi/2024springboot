package com.sample.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping("/hello")
    public String hello() {
        return "get-hello";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "post-hello";
    }

    @PutMapping("/hello")
    public String putHello() {
        return "put-hello";
    }

    @DeleteMapping("/hello")
    public String deleteHello() {
        return "delete-hello";
    }

    @GetMapping("/test/param") // param?name=&age=
    public String requestParam(@RequestParam("name") String name,
                               @RequestParam("age") Integer age) {

        return "hello, request param, I am " + name +", "+ age;
    }

    @GetMapping("/test/path/{name}/{age}") // pathvariable 사용방법
    public String requestPathVariable(@PathVariable("name") String name,
                                      @PathVariable("age") Integer age) {
        return "hello, request param, I am " + name +", "+ age;
    }

    @PostMapping("/test")
    public String requestBody( @RequestBody RequestDto request) {
        return "hello, request param, I am " + request.getName() + ", " + request.getAge();
    }


}
