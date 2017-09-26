package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.entity.Order;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.ItemRepository;
import com.thoughtworks.futurestar.repository.OrderRepository;
import com.thoughtworks.futurestar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Order createOrder(User user, List<String> itemIds) {
        List<Item> item = itemRepository.findAll(itemIds);
        Order order = Order.builder().id(UUID.randomUUID().toString()).user(user).itemList(item).build();

        return orderRepository.save(order);
    }
}
