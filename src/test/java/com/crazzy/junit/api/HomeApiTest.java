package com.crazzy.junit.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HomeApi.class)
class HomeApiTest {

    private MockMvc mockMvc;

    @Autowired
    HomeApiTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void getHome() throws Exception {
        // Create Request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/home")
                .accept(MediaType.APPLICATION_JSON);

        // Call Endpoint /home
        MvcResult mvcResult = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andReturn();

        // verify response : App is up
        assertEquals("App is up", mvcResult.getResponse().getContentAsString());
    }
}