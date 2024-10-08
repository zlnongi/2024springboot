package com.sample.spring.controller;

import com.sample.spring.domain.Member;
import com.sample.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    // memberservice를 주입해줘야됨. 주입하고 사용하고 해야함
    @Autowired
    private MemberService memberService;

    @RequestMapping("/")
    public @ResponseBody String root() {
        return "test";
    }

    @RequestMapping ("/all")
    public String selectAll(Model model) { // selectAll의 jsp 파일에다가 인자값을 보내서 화면에 띄워줘야함 model로 담아서
        //값을 가져와야함
        List<Member> result = memberService.selectAll();
        model.addAttribute("members",  result);
        return "selectAll"; // 얜 jsp 파일명
    }

    @RequestMapping ("/insert") // post 방식 -> insert?name=   &email=
    public String insert(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         Model model) {
        Member member = Member.builder().name(name).email(email).createDate(LocalDate.now()).build();

        Member result = memberService.insert(member);
        model.addAttribute("member", result); // 화면에 뿌려주기
        return "insert";
    }

    @RequestMapping("/view") // view?id=10
    public String view(@RequestParam("id") Long id, Model model) {
        Optional<Member> result = memberService.view(id); // MemberService.java의 view 메서드
        // result 값으로 변경돼서 나옴
        if(result.isPresent()) { // result 값 있음
            model.addAttribute("member", result.get());
        } else { // result 값 없음
            model.addAttribute("member", null); // 소스 터지지 않게 하기 위해
        }
        return "view";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        memberService.delete(id);
        return "delete";
    }

    @RequestMapping("/selectByName")
    public String selectByName(@RequestParam("name") String search,
                               @RequestParam("page") String page,
                               Model model) {
        System.out.println("/-----------------------------"+search+"---------------------------------/");
        System.out.println("/-----------------------------"+page+"---------------------------------/");
        // 데이터 들어오는 것을 확인

        String name = search + "%"; // sql에서 단어를 찾을때 쓰는것임 ...
        Sort sort = Sort.by(Sort.Order.desc("id"));
        int nPage = Integer.parseInt(page)-1; // 1이 들어오면 0이라고 뜸???????? 쩝

        Pageable pageable = PageRequest.ofSize(10).withPage(nPage).withSort(sort);
        // 페이지의 크기 & 몇번째 & sort

        Page<Member> result = memberService.selectNameLike(name, pageable);
        List<Member> content = result.getContent();
        long totalElements = result.getTotalElements();
        int  totalPages    = result.getTotalPages();
        int  size          = result.getSize();
        int  pageNumber    = result.getNumber() + 1;    // 0부터 시작하므로
        int  numberOfElements = result.getNumberOfElements(); // content의 개수

        model.addAttribute("members", content);
        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("size", size);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("numberOfElements", numberOfElements);

        return "selectList"; // 검색해서 나온 페이지가 여기에서 뜬다
    }


}
