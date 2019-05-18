package com.myRetail.myRetail.controller;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.myRetail.myRetail.MyRetailApplication;
import com.myRetail.myRetail.model.CurrentPrice;
import com.myRetail.myRetail.model.Product;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyRetailApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiControllerTest {

    private MockMvc mockMvc;


    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void addProduct() throws  Exception {

        String json ="{\"id\":0,\"name\":\"The Big Lebowski (Blu-ray) (Widescreen) \",\"current_price\":{\"value\":15.05,\"currency_code\":\"USD\"}}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/addProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.is(15117729)))
                .andExpect(jsonPath("$.name", Matchers.is("The Big Lebowski (Blu-ray) (Widescreen) ")))
                .andDo(print());
    }

    @Test
    public void getProduct() throws  Exception{

      mockMvc.perform(MockMvcRequestBuilders.get("/api/products/15117756")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(15117756)))
                .andExpect(jsonPath("$.name", Matchers.is("The Big Lebowski (Blu-ray) (Widescreen) ")));
    }




}