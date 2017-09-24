package com.thoughtworks.future_star.api;

import com.thoughtworks.Application;
import com.thoughtworks.future_star.dto.UserConfigDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserTest {
    
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }

    @Test
    void should_return_create_user_success() throws Exception {
        UserConfigDTO userConfigDTO = UserConfigDTO.builder().age(15).username("username").password("password").build();
        StringUtils.writeObjectAsJsonString(userConfigDTO);
        mockMvc.perform(post("/api/users")
                .content(StringUtils.writeObjectAsJsonString(userConfigDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", is("create success")));
    }
}
