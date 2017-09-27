package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item create(@RequestBody Item item) {
        return itemServiceImpl.create(item);
    }

    @GetMapping
    public List<Item> items() {
        return itemServiceImpl.getAll();
    }
}
