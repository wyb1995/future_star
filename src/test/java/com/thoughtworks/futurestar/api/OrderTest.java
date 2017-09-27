package com.thoughtworks.futurestar.api;


import com.thoughtworks.Application;
import com.thoughtworks.futurestar.cache.SessionCache;
import com.thoughtworks.futurestar.dto.OrderDTO;
import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.ItemRepository;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.ShoppingCartService;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@Transactional
public class OrderTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingCartService shoppingCartServiceImpl;

    private Item item;

    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        item = Item.builder().id(UUID.randomUUID().toString())
                .name("test").price("20").build();
        itemRepository.save(item);

        User user = User.builder().id(UUID.randomUUID().toString()).
                username("username").password("password").age(20).orders(Collections.EMPTY_LIST).build();
        userRepository.save(user);

        shoppingCartServiceImpl.addItemToShoppingCart(user.getId(), item.getId());

        SessionCache sessionCache = new SessionCache();
        sessionCache.setUser(userRepository.save(user));
    }

    @Test
    void should_return_create_order_success() throws Exception {
        List<String> itemIds = new ArrayList<>();
        itemIds.add(item.getId());
        OrderDTO orderDTO = OrderDTO.builder().address("shanxi").itemIds(itemIds).build();
        mockMvc.perform(post("/api/order")
                .contentType(MediaType.APPLICATION_JSON).content(StringUtils.writeObjectAsJsonString(orderDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.address", is("shanxi")));
    }
}
