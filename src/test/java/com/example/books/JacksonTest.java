package com.example.books;

import com.example.books.domain.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTest {

    @Test
    public void testThatObjectMapperCanConvertToJSONFromJavaObject() throws JsonProcessingException {
        Book book = Book.builder()
                .isbn("Book_1")
                .title("Sach giao khoa toan")
                .author("Nguyen, Son Chu")
                .yearPublished("2010")
                .build();

        final ObjectMapper objectMapper = new ObjectMapper();

        String rs = objectMapper.writeValueAsString(book);

        assertThat(rs).isEqualTo("{\"isbn\":\"Book_1\",\"title\":\"Sach giao khoa toan\",\"author\":\"Nguyen, Son Chu\",\"year\":\"2010\"}");
    }


    @Test
    public void testThatObjectMapperCanTurnJSONToJavaObject() throws JsonProcessingException {
        Book book = Book.builder()
                .isbn("Book_1")
                .title("Sach giao khoa toan")
                .author("Nguyen, Son Chu")
                .yearPublished("2010")
                .build();
        final ObjectMapper objectMapper = new ObjectMapper();

        String json = "{\"foo\":\"bar\",\"isbn\":\"Book_1\",\"title\":\"Sach giao khoa toan\",\"author\":\"Nguyen, Son Chu\",\"year\":\"2010\"}";

        Book rs = objectMapper.readValue(json, Book.class);

        assertThat(rs).isEqualTo(book);
    }
}
