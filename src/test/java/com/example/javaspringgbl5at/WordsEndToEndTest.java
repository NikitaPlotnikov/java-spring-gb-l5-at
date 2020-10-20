package com.example.javaspringgbl5at;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.Map;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WordsEndToEndTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void endToEndTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/words?filename=lotr"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String responseWordsAsString = mvcResult.getResponse().getContentAsString();
        Map response = objectMapper.readerFor(Map.class).readValue(responseWordsAsString, Map.class);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.get("good"));
        Assertions.assertEquals(207, response.get("aragorn"));
        Assertions.assertEquals(2, response.get("kibil-nala"));
        Assertions.assertEquals(11723, response.get("the"));
    }
}