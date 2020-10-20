package com.example.javaspringgbl5at.servise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class WordsCounterServiceTest {


    @Test
    void countWordsInLine() {
        WordsCounterService wordsCounterService = new WordsCounterService();
        String shortTestString = "Grut! I am Grut!";

        Assertions.assertNotNull(wordsCounterService.countWordsInLine(shortTestString));
        Assertions.assertEquals(3, wordsCounterService.countWordsInLine(shortTestString).size());
        Assertions.assertEquals(2, wordsCounterService.countWordsInLine(shortTestString).get("grut").longValue());
    }
}