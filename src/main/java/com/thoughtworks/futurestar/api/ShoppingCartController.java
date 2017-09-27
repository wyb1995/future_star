package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.cache.SessionCache;
import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-carts")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartServiceImpl;

    @Autowired
    private SessionCache sessionCache;

    @GetMapping
    public List<Item> getItemList() {
        User user = sessionCache.loadCurrentUser();
        return shoppingCartServiceImpl.getShoppingCart(user.getId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Item> addItemToShoppingCart(@RequestBody String itemId) {
        User user = sessionCache.loadCurrentUser();
        return shoppingCartServiceImpl.addItemToShoppingCart(user.getId(), itemId);
    }
}
