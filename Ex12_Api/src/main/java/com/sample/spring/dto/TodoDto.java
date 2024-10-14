package com.sample.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto { // 받아오는 거면서 보내주는 것
    private Long tno;
    private String title;
    private String write;
    private boolean complete;
    private LocalDate duedate;
}

//public class TodoRequest {
//    private String title;
//    private String write;
//    private boolean complete;
//    private LocalDate duedate;
//}
