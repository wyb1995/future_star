package com.thoughtworks.futurestar.api;

import com.thoughtworks.Application;
import com.thoughtworks.futurestar.cache.SessionCache;
import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.service.ItemService;
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

import javax.transaction.Transactional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@Transactional
public class ShoppingCartTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    private Item item;

    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        item = Item.builder().name("test").price("20").build();

        itemService.create(item);

        User user = User.builder().username("username").password("password").age(20).build();

        user = userService.create(user);

        SessionCache sessionCache = new SessionCache();

        sessionCache.setUser(user);
    }

    @Test
    void should_return_empty_shopping_cart() throws Exception {
        mockMvc.perform(get("/api/shopping-carts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void should_add_item_to_cart() throws Exception {
        mockMvc.perform(post("/api/shopping-carts")
                .content("" + item.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
