package com.example.javaspringgbl5at.servise;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

@Service
public class FileProcessorService {

    private final WordsCounterService wordsCounterService;

    public FileProcessorService(WordsCounterService wordsCounterService) {
        this.wordsCounterService = wordsCounterService;
    }

    public Map<String,Long> fileSplitToLines(Resource book) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(book.getFile()));
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        String fileAsString = stringBuilder.toString();

            return wordsCounterService.countWordsInLine(fileAsString);
    }

}
