package com.projetointegrador.service.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldInsert ( ) throws Exception {

        String payLoad = "{\n" +
                "    \"productId\": \"MLB-122\",\n" +
                "    \"name\": \"Banana\",\n" +
                "    \"description\":\"Caixa de Banana\",\n" +
                "    \"typeId\": \"1\"\n" +
                "}";

        mockMvc.perform(
                        MockMvcRequestBuilders.post("http://localhost:8090/api/v1/product/insert")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoad))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldInsertOrders ( ) throws Exception {

        String payLoad = "{\n" +
                "    \"date\":\"2021-10-31\",\n" +
                "    \"buyerId\": 1,\n" +
                "    \"orderStatus\":{\n" +
                "        \"statusCode\":\"cart\"\n" +
                "    },\n" +
                "    \"products\":[\n" +
                "        {\n" +
                "            \"productId\": \"MLB-126\",\n" +
                "            \"quantity\": 6            \n" +
                "        }\n" +
                "    ]\n" +
                "}";

        mockMvc.perform(
                        MockMvcRequestBuilders.post("http://localhost:8090/api/v1/product/orders")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoad))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldGetProductSeller ( ) throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8090/api/v1/product/list"))

                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldListOrdersByOrderId ( ) throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8090/api/v1/product/orders/1"))

                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldupdate ( ) throws Exception {

        String payLoad = "{\n" +
                "    \"products\":[\n" +
                "        {\n" +
                "            \"purchaseItemId\": 1,\n" +
                "            \"productId\": \"MLB-126\",\n" +
                "            \"quantity\": 1           \n" +
                "        }\n" +
                "    ]\n" +
                "}";

        mockMvc.perform(
                        MockMvcRequestBuilders.put("http://localhost:8090/api/v1/product/orders/update")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoad))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void shouldHistoryBuyer ( ) throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8090/api/v1/product/history/buyer/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldHistoryInsert ( ) throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8090/api/v1/product/hystory/insert"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldHistory ( ) throws Exception {

        mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8090/api/v1/product/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}