package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService itemServiceImpl;

    @PostMapping
    public List<Item> createItem(@RequestBody Item item) {
        itemServiceImpl.create(item);
        return itemList();
    }

    @GetMapping
    public List<Item> itemList(){
        return itemServiceImpl.getAllItem().isEmpty() ? null : itemServiceImpl.getAllItem();
    }
}
