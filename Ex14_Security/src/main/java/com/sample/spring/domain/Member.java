package com.sample.spring.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "memberRoleList")
public class Member {
    @Id
    private String email; // 기본값을 얘로 할거임 -> username이 됨

    private String pw;
    private String nickname;
    private boolean social;
    // 변경해야하는 것들 = setter

    @ElementCollection(fetch = FetchType.LAZY) // 자동으로 DB가 생기게 해줌?? 필요할때 부르는 것 : fetch lazy
    @Builder.Default
    private List<MemberRole> memberRoleList = new ArrayList<>();

    public void addRole(MemberRole memberRole) { // addRole이 db에 생성됨
        memberRoleList.add(memberRole);

    }

    public void clearRoles() {
        memberRoleList.clear();
    }

    // setter들임 (수정 위한)
    public void changePw(String pw) {
        this.pw = pw;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeSocial(boolean social) {
        this.social = social;
    }

}
