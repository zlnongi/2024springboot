package com.sample.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PageRequestDto {
    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 10;

}
