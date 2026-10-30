package com.example.az_cicd_application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomeEndpoint() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        org.hamcrest.Matchers.containsString(
                                "Deployment successful!"
                        )
                ));
    }

    @Test
    void testHealthEndpoint() throws Exception {

        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }
}
