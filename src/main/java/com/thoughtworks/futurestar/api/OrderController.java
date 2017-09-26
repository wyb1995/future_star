package com.thoughtworks.futurestar.api;

import com.thoughtworks.futurestar.cache.SessionCache;
import com.thoughtworks.futurestar.dto.OrderDTO;
import com.thoughtworks.futurestar.entity.Order;
import com.thoughtworks.futurestar.entity.ShoppingCart;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.service.OrderService;
import com.thoughtworks.futurestar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderServiceImpl;

    @Autowired
    private ShoppingCartService shoppingCartServiceImpl;

    @Autowired
    private SessionCache sessionCache;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody OrderDTO orderDTO) {
        User user = sessionCache.loadCurrentUser();
        List<String> itemIds = orderDTO.getItemIds();
        System.out.println(itemIds);
        Order order = orderServiceImpl.createOrder(user, itemIds);
        if (order != null) {
            shoppingCartServiceImpl.deleteItemWithShoppingCart(user.getId(), itemIds);
        }
        return order;
    }

    @GetMapping("/{order_id}")
    public Order getOrder(@PathVariable String order_id) {
        User user = sessionCache.loadCurrentUser();
        return orderServiceImpl.getOrder(user, order_id);
    }
}
