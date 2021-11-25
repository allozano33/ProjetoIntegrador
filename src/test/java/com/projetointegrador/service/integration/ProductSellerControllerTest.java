package com.projetointegrador.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetointegrador.dto.TokenDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductSellerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeTestClass
    public TokenDto auth() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        String payLoadLogin = "{\n" +
                "    \"user\": \"wesley\",\n" +
                "    \"senha\": \"123\"\n" +
                "}";

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("http://localhost:8090/api/v1/auth")
                        .content(payLoadLogin)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        TokenDto tokenDTO = mapper.readValue(response, TokenDto.class);

        return tokenDTO;
    }

    @Test
    public void shouldInsert() throws Exception {

        String payLoad = "{\n" +
                "\t\"volume\": 80,\n" +
                "\t\"maximumTemperature\": 23,\n" +
                "\t\"minimumTemperature\": 9.5,\n" +
                "    \"sellerId\": 1,\n" +
                "    \"productId\": \"MLB-129\",\n" +
                "    \"price\":20\n" +
                "}";

        mockMvc.perform(
                        MockMvcRequestBuilders.post("http://localhost:8090/api/v1/product-seller/insert")
                                .contentType(MediaType.APPLICATION_JSON)
                                .header("Authorization", "Bearer " + auth().getToken())
                                .content(payLoad))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}



