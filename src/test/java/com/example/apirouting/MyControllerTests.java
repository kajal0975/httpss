package com.example.apirouting;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.apirouting.MyController;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    MockHttpServletRequestBuilder mockRequest1 = MockMvcRequestBuilders.get("/").contentType(MediaType.TEXT_PLAIN);
    MockHttpServletRequestBuilder mockRequest2 = MockMvcRequestBuilders.get("/about").contentType(MediaType.TEXT_PLAIN);

    @Test
    @Order(1)
    public void testgetHomePage() throws Exception {
        mockMvc.perform(mockRequest1).andExpect(status().isOk());

    }

    @Test
    @Order(2)
    public void testHomePage() throws Exception {
        mockMvc.perform(mockRequest1).andExpect(jsonPath("$", Matchers.equalTo("Home Page")));
    }

    @Test
    @Order(3)
    public void testgetAboutPage() throws Exception {
        mockMvc.perform(mockRequest2).andExpect(status().isOk());
    }

    @Test
    @Order(4)
    public void testAboutPage() throws Exception {
        mockMvc.perform(mockRequest2).andExpect(jsonPath("$", Matchers.equalTo("About Page")));
    }

}
