package com.sample.spring.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewRequest { // 받는 것
    private Long foodId;
    private String content;
    private Double score;
}
