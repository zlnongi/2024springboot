package com.sample.sprirng.dto;

import lombok.Data;

@Data
public class SimpleBbsDto { // 그냥 여기저기 사용되고 버려짐 (수단)
    int id;
    String writer;
    String title;
    String content;
}
