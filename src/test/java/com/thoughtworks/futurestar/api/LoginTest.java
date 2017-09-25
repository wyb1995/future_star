package com.thoughtworks.futurestar.api;

import com.thoughtworks.Application;
import com.thoughtworks.futurestar.dto.LoginDataDTO;
import com.thoughtworks.futurestar.dto.UserConfigDTO;
import com.thoughtworks.futurestar.service.UserService;
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
public class LoginTest {
    
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        UserConfigDTO userConfigDTO = UserConfigDTO.builder().username("username").password("password").age(15).build();
        UserService.userDataMap.put(1, userConfigDTO);
    }

    @Test
    void should_return_login_success() throws Exception {
        LoginDataDTO loginDataDTO = LoginDataDTO.builder().username("username").password("password").build();
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(StringUtils.writeObjectAsJsonString(loginDataDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("username login successfully.")));
    }

    @Test
    void should_return_login_error() throws Exception{
        LoginDataDTO loginDataDTO = LoginDataDTO.builder().username("username").password("error_password").build();
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(StringUtils.writeObjectAsJsonString(loginDataDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("login error")));
    }
}
