package com.crazzy.junit.api;

import com.crazzy.junit.entity.Item;
import com.crazzy.junit.service.ItemService;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemApi.class)
@Slf4j
class ItemApiTest {

    private MockMvc mockMvc;

    @MockBean
    private ItemService service;

    @Autowired
    ItemApiTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void getItem() throws Exception {

        // Create Request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);

        // Call Endpoint /item
        MvcResult mvcResult = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"Bread\",\n" +
                        "    \"price\": 10,\n" +
                        "    \"quantity\": 28\n" +
                        "}"))
                .andReturn();
    }

    @Test
    void getItemFromService() throws Exception {

        // Mock
        when(service.getItem()).thenReturn(new Item(1L, "Bread", 10, 28));

        // Create Request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item/service")
                .accept(MediaType.APPLICATION_JSON);

        // Call Endpoint /item
        MvcResult mvcResult = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1, name:Bread, price:10, quantity:28}"))
                .andReturn();

    }

    @Test
    void findAll() throws Exception {

        // Mock
        when(service.findAll()).thenReturn(Arrays.asList(
                new Item(1L, "item1", 10, 12),
                new Item(2L, "item2", 12, 24)
        ));

        // Create Request
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item/all")
                .accept(MediaType.APPLICATION_JSON);

        // Call Endpoint /item
        MvcResult mvcResult = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{id:1, name:item1, price:10, quantity:12}," +
                        "{id:2, name:item2, price:12, quantity:24}" +
                        "]"))
                .andReturn();

    }
}