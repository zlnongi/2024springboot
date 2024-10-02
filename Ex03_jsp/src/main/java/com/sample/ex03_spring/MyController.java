package com.sample.ex03_spring;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @RequestMapping("/") //
    public @ResponseBody String root () { //응답되는 값을 보내줌
        return "jsp test";

    }
    @RequestMapping("/test")
    public String test() {
        return "test"; // test.jsp로 가야함... ㅠㅠ
    }

    @RequestMapping("/test1")
    public String test1() {
        return "sub/test1";
    }

    @RequestMapping("/model")
    public String model(Model model) {
        model.addAttribute("name", "홍길동"); // Attribute를 하나 만들어주겠다
        return "model";
    }

    @RequestMapping("/mv")
    public ModelAndView mv2() {
        ModelAndView mv = new ModelAndView(); // mv에 ModelAndView를 사용해서 화면에 뿌려두기 위한거임

        List<String> list = new ArrayList<>(); // 배열데이터
        list.add("test1");
        list.add("test2");
        list.add("test3");

        mv.addObject("lists", list); // 오브젝트화 해줘야함
        // lists는 model.jsp에서 사용함 list는 여기서 내가 만든 배열
        mv.addObject("name", "홍길동");

        mv.setViewName("view/mv"); // mv가 파일명임 mv를 뽑아낸다

        return mv;
    }

    @RequestMapping("/index") // 인덱스가 들어왔을 때 어떻게 할 것인지? getParameter로 사용
    // index?name=여진홍
    public String index(HttpServletRequest request, Model model) { // model에 뿌려주겠다
        String name = request.getParameter("name");

        model.addAttribute("name", name); // 여진홍이 출력이됨
        return "index"; // index라는 파일명
    }
}
