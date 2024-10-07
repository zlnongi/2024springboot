package com.sample.spring.service;

import com.sample.spring.dto.SimpleBbsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISimpleBbsService {
    public List<SimpleBbsDto> list();
    public int count();
    public SimpleBbsDto view(String id);
    public int write(String writer,String title, String content);
    public int delete(@Param("_id") String id);
}

// Controller에서 바로 DAO 부르지않음
// Contoroller가 진입점 -> 비밀번호를 저장만하는게 아니라 원래 풀고 기존비밀번호와 맞는지 체크 등등...  여러 로직들이 존재하는데!!!!
// 모든 로직들이 컨트롤러에 있으면 AOP에 맞지않는다 !!! Controller는 정말 이걸 return해줄게!!!만 해야됨 (딱 리모컨에서 버튼 누르면 켜지기만 하기)
// 검사하고 이런건 다 비즈니스로직인데 그게 모여있는것이 Service다!! Service라는 관점을 잡은 것.