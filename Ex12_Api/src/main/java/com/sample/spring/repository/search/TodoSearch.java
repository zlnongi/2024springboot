package com.sample.spring.repository.search;

import com.sample.spring.dto.PageRequestDto;
import com.sample.spring.model.TodoEntity;
import org.springframework.data.domain.Page;

public interface TodoSearch {
    Page<TodoEntity> search1(PageRequestDto pageRequestDto);
}
