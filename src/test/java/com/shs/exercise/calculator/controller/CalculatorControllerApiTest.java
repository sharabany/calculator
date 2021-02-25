package com.shs.exercise.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shs.exercise.calculator.data.Calculator;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@WebMvcTest(CalculatorController.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureWebMvc
public class CalculatorControllerApiTest {

    public MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test_when_input_is_null_then_get_error() throws Exception {
        setup();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
                .post("/employees")
                .content(asJsonString(new Calculator(1, 2, "plus"))))
                .andExpect(status().isOk()).andReturn();

        assertThat(mvcResult.getAsyncResult().toString(), equalTo("1 + 2 = 3"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
