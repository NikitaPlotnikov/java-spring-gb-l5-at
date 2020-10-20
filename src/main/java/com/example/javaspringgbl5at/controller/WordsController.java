package com.example.javaspringgbl5at.controller;

import com.example.javaspringgbl5at.servise.FileSystemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class WordsController {

    private final FileSystemService fileSystemService;

    public WordsController(FileSystemService fileSystemService) {
        this.fileSystemService = fileSystemService;
    }

    @GetMapping("/words")
    public Map<String, Long> askAppToCount (@RequestParam String filename) throws IOException {
        Map<String, Long> bookToReturn;
        bookToReturn = fileSystemService.fileSystem(filename);
        return bookToReturn;
    }
}
