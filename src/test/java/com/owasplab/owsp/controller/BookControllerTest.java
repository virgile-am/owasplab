package com.owasplab.owsp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.owasplab.owsp.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenSpecialCharactersInput_thenReturnsEncodedOutput() throws Exception {
        Book xssBook = new Book();
        xssBook.setTitle("<script>alert('XSS')</script>");
        xssBook.setAuthor("Eve");
        xssBook.setPublishedYear(2022);

        mockMvc.perform(post("/api/v1/books")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(xssBook)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("<script>alert('XSS')</script>")); // JSON encoding should prevent XSS
    }


}
