package com.act.moneytransferapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Biniam Asnake
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    public void shouldCreateAccountGivenCorrectInput() throws Exception {

        mockMvc.perform(
                post("/api/account/create")
                        .accept("application/json")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"firstName\" : \"Biniam\",\n" +
                                "    \"lastName\" : \"Asnake\",\n" +
                                "    \"email\": \"biniamasnake@gmail.com\",\n" +
                                "    \"phoneNumber\": \"+251 966-272502\",\n" +
                                "    \"pin\": \"1234\"\n" +
                                "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(
                        objectMapper.readValue(new File("/Users/biniam.asnake/projects/money-transfer-api-act/src/test/json/create_account_response.json"), Object.class))));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfRequiredFieldIsMissing() throws Exception {

        mockMvc.perform(
                post("/api/account/create")
                        .accept("application/json")
                        .contentType("application/json")
                        .content("{\n" +
                                "    \"lastName\" : \"Asnake\",\n" +
                                "    \"email\": \"\",\n" +
                                "    \"phoneNumber\": \"+251 966-272502\",\n" +
                                "    \"pin\": \"1234\"\n" +
                                "}"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
