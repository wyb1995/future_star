package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartServiceImpl;

    @GetMapping("/{user_id}")
    public List<Item> getItemList(@PathVariable String user_id) {
        return shoppingCartServiceImpl.getShoppingCart(user_id);
    }

    @PostMapping("/{user_id}/{item_id}")
    public List<Item> addItemToShoppingCart(@PathVariable String user_id, @PathVariable String item_id) {
        return shoppingCartServiceImpl.addItemToShoppingCart(user_id, item_id);
    }
}
