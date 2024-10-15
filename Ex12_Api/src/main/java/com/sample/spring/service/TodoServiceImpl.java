package com.sample.spring.service;

import com.sample.spring.dto.PageRequestDto;
import com.sample.spring.dto.PageResponseDto;
import com.sample.spring.dto.TodoDto;
import com.sample.spring.model.TodoEntity;
import com.sample.spring.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoDto get(Long tno) {
        Optional<TodoEntity> result = todoRepository.findById(tno);
        // java는 null 처리 안됨 (nullable 안됨)
        // 처리는 해야함 ->   처리할 수 잇도록 해놓은 객체 = Optional
        // Optional<type명시> jpa 쓰면 다 optional
        TodoEntity todo = result.orElseThrow(); // orElseThrow() -> data 있으면 result를 그냥 todo로
        // 값이 없으면(null이면) error를 발생시켜라

        return entityToDto(todo); // todoentity를 tododto로 변환시켜줌
    }

    @Override
    public Long postTodo(TodoDto dto) { // 값을 넘기는 것이므로 entity로 save해줘야됨
        TodoEntity todo = dtoToEntity(dto);
        TodoEntity result = todoRepository.save(todo);

        return result.getTno();
    }

    @Override
    public void modify(TodoDto dto) {
        Optional<TodoEntity> result = todoRepository.findById(dto.getTno());
        TodoEntity todo = result.orElseThrow();

        todo.changeTitle(dto.getTitle());
        todo.changeComplete(dto.isComplete());
        todo.changeDueDate(dto.getDuedate());

//        TodoEntity newTodo = TodoEntity.builder()
//                .tno(todo.getTno())
//                .title(dto.getTitle())
//                .writer(todo.getWriter())
//                .complete(dto.isComplete())
//                .dueDate(dto.getDuedate())
//                .build();
//
//        todoRepository.save(newTodo);

        todoRepository.save(todo);

    }

    @Override
    public void remove(Long tno) {
        todoRepository.deleteById(tno);
    }

    @Override
    public PageResponseDto<TodoDto> getList(PageRequestDto pageRequestDto) {
        Page<TodoEntity> result = todoRepository.search1(pageRequestDto);

        List<TodoDto> dtoList = result.get().map(todo -> entityToDto(todo)).collect(Collectors.toList());
        PageResponseDto<TodoDto> responseDto = PageResponseDto.<TodoDto>withAll()
                .dtoList(dtoList)
                .pageRequestDto(pageRequestDto)
                .total(result.getTotalElements())
                .build();

        return responseDto;
    }

}
