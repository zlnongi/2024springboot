package com.sample.spring.controller;

import com.sample.spring.service.FileDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FileController {

    private final FileDataService fileDataService;

    public FileController(FileDataService fileDataService) {
        this.fileDataService = fileDataService;
    }

    @PostMapping("/file")
    public ResponseEntity<?> uploadImage(
            @RequestParam("images")List<MultipartFile> files
            ) throws IOException {
        List<String> uploadResult = files.stream().map(
                file ->{
                    try {
                        return fileDataService.uploadImageToFileSystem(file);
                    } catch(IOException e) {
                        e.printStackTrace();
                        return "failed";
                    }
                }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(uploadResult);
    }
}
