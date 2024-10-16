package com.sample.spring.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.*;
import java.util.stream.Collectors;

public class MemberDto extends User {


    public String email,pw, nickname;
    private boolean social;
    private List<String> roleNames = new ArrayList<>();

    public MemberDto(String email, String pw, String nickname, boolean social, List<String> roleNames) {
        super(email, pw, roleNames.stream().map(str->new SimpleGrantedAuthority("ROLE_" + str)).collect(Collectors.toList()));
        // User에 있는 값들이 super임
        this.email = email;
        this.pw = pw;
        this.nickname = nickname;
        this.social = social;
        this.roleNames = roleNames;
    }

    public Map<String, Object> getClaims() {
        Map<String, Object> dataMap = new HashMap<>();
        //dataMap에 put해서 넣어줌
        dataMap.put("email", email);
        dataMap.put("pw", pw);
        dataMap.put("nickname", nickname);
        dataMap.put("social", social);
        dataMap.put("roleNames", roleNames);

        return dataMap;
    }
}
