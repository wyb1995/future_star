package com.thoughtworks.futurestar.api;

import com.thoughtworks.Application;
import com.thoughtworks.futurestar.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@Transactional
public class UserTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private User user;


    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        user = User.builder().age(15).username("username").password("password").build();
    }

    @Test
    void should_return_create_user_success() throws Exception {
        StringUtils.writeObjectAsJsonString(user);
        mockMvc.perform(post("/api/users")
                .content(StringUtils.writeObjectAsJsonString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", is("username create successful.")));
    }

    @Test
    @Disabled
    void should_return_user_list() throws Exception{
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].username", is("username")));
    }

    @Test
    @Disabled
    void should_return_update_user_age_success() throws Exception{
        mockMvc.perform(put("/api/users/1/age/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("update you info success")));
    }

    @Test
    @Disabled
    void should_return_update_user_age_error() throws Exception{
//        UserService1.userDataMap.clear();
        mockMvc.perform(put("/api/users/1/age/123"))
                .andExpect(jsonPath("$", is("update you info error")));
    }

    @Test
    @Disabled
    void should_return_age_is_15_user_list() throws Exception{
        mockMvc.perform(get("/api/users?age=15"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].age", is(15)));
    }
}
