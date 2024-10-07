package com.sample.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    private IMyUserDao dao;

    @RequestMapping("/user")
    public String userlistpage(Model model) {
        model.addAttribute("users", dao.list());
        return "userlist";
    }

}
