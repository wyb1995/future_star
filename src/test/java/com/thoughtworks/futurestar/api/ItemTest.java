package com.thoughtworks.futurestar.api;

import com.thoughtworks.Application;
import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.repository.ItemRepository;
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
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@Transactional
public class ItemTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ItemRepository itemRepository;

    private Item item;
    private Item item1;

    @BeforeEach
    void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        item = Item.builder().id(UUID.randomUUID().toString())
                .name("test").price("20").build();
        item1 = Item.builder().id(UUID.randomUUID().toString())
                .name("test1").price("20").build();
    }

    @Test
    void should_return_one_item_list() throws Exception {
        mockMvc.perform(post("/api/item")
                .contentType(MediaType.APPLICATION_JSON)
                .content(StringUtils.writeObjectAsJsonString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void should_return_empty_item_list() throws Exception {
        itemRepository.save(item);
        itemRepository.save(item1);
        mockMvc.perform(get("/api/item"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
}
