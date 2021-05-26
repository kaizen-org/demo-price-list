package com.zara.prices.web.rest;

import com.zara.prices.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
class PriceResourceIT {

    @Autowired
    private MockMvc restMockMvc;

    @Test
    void shouldObtainPrice() throws Exception {
        MvcResult result = restMockMvc.perform(get("/api/price?"))
                .andExpect(status().isOk()).andReturn();
        result.getResponse().getContentAsString();


    }

}
