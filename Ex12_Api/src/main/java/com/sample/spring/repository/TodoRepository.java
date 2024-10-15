package com.sample.spring.repository;

import com.sample.spring.model.TodoEntity;
import com.sample.spring.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>, TodoSearch {
}
