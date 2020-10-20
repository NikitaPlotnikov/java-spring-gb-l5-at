package com.example.javaspringgbl5at.servise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.Map;

@SpringBootTest
class FileSystemServiceTest {
    @Value("classpath:lotr.txt")
    Resource lotr;
    @Test
    void fileSystem() throws IOException {
        FileProcessorService fileProcessorService = new FileProcessorService(new WordsCounterService());
        Map<String, Long> stringLongMap = fileProcessorService.fileSplitToLines(lotr);
        Assertions.assertNotNull(stringLongMap);
        Assertions.assertEquals(200, stringLongMap.get("good").longValue());
        Assertions.assertEquals(207, stringLongMap.get("aragorn").longValue());
        Assertions.assertEquals(2, stringLongMap.get("kibil-nala").longValue());
        Assertions.assertEquals(11723, stringLongMap.get("the").longValue());
    }
}