package com.sample.spring.repository;

import com.sample.spring.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileEntity, Long> {
}
