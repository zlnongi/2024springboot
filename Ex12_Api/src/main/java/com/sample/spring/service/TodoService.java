package com.sample.spring.service;

import com.sample.spring.dto.TodoDto;
import com.sample.spring.model.TodoEntity;

public interface TodoService {
    public TodoDto get(Long tno); // Dto로 받아야될 것

    public Long PostTodo(TodoDto dto);

    public void modify(TodoDto dto);

    public void remove(Long tno);

    default TodoDto entityToDto(TodoEntity todo) { // entity 값이 들어오면 Dto값으로 바꿔줌
        TodoDto todoDto = TodoDto.builder()
                .tno(todo.getTno())
                .title(todo.getTitle())
                .write(todo.getWriter())
                .complete(todo.isComplete())
                .duedate(todo.getDueDate()).build();
        return todoDto;
    }

    default TodoEntity dtoToEntity(TodoDto todoDto) { // db에 넣을때는 entity타입으로 바꿔줘서 넣어줌 (save할때 필요)
        TodoEntity todoEntity = TodoEntity.builder()
                .tno(todoDto.getTno())
                .title(todoDto.getTitle())
                .writer(todoDto.getWrite())
                .complete(todoDto.isComplete())
                .dueDate(todoDto.getDuedate())
                .build();
        return todoEntity;
    }
}
