package com.example.javaspringgbl5at.servise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class FileSystemService {

    private final FileProcessorService fileProcessorService;

    public FileSystemService(FileProcessorService fileProcessorService) {
        this.fileProcessorService = fileProcessorService;
    }

    @Value("classpath:lotr.txt")
    Resource lotr;

    @Value("classpath:dune.txt")
    Resource dune;

    public Map<String, Long> fileSystem(String nameBook) throws IOException {
        Map<String, Long> bookToReturn = null;
        switch (nameBook) {
            case "lotr":
                bookToReturn = fileProcessorService.fileSplitToLines(lotr);
                break;
            case "dune":
                bookToReturn = fileProcessorService.fileSplitToLines(dune);
                break;
        }
        return bookToReturn;
    }
}
