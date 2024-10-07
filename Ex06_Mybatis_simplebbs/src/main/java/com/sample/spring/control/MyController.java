package com.sample.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.spring.dao.ISimpleBbsDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @Autowired
    ISimpleBbsDao dao;


    @RequestMapping("/")
    public String root() {
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String listPage(Model model) {
        model.addAttribute("lists", dao.listDao());
        //model.addAttribute("count", dao.countDao());
        return "list";
    }

    @RequestMapping("/view") // view?id=1
    public String view(HttpServletRequest request, Model model) {
        String sId = request.getParameter("id");
        model.addAttribute("dto", dao.viewDao(sId));
        return "view";
    }

    @RequestMapping("/writeForm")
    public String writeForm() { // 해당되는 페이지로 연결만 시켜주면 되므로 () 비어있음
        return "writeForm";
    } // writeForm으로 감 -> writer title content 적고 글쓰기버튼 누름 ->
    // write라는 포스트로 이동시킴 writerdao로 값 insert해주고 list페이지로 redirect

    @RequestMapping("/write")
    public String write(HttpServletRequest request) {
        dao.writeDao(request.getParameter("writer"),request.getParameter("title"), request.getParameter("content") );
        // writeForm에 작성되어있는 값을 넘겨줘야함
        // 0과 1이 나옴 data가 들어갔을때 & data가 들어가지 않을때
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request) { // 0값으로 들어옴
        dao.delete(request.getParameter("id")); // id값을 request통해서 가져옴
        return "redirect:/list";
    }
}