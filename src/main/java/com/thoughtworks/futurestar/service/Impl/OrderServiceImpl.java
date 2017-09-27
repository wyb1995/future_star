package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.dto.OrderDTO;
import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.entity.Order;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.ItemRepository;
import com.thoughtworks.futurestar.repository.OrderRepository;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.OrderService;
import com.thoughtworks.futurestar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ShoppingCartServiceImpl shoppingCartServiceImpl;

    @Override
    public Order createOrder(User user, OrderDTO orderDTO) {
        String address = orderDTO.getAddress();
        List<String> itemIds = orderDTO.getItemIds();
        List<Item> item = itemRepository.findAll(itemIds);
        Order order = Order.builder().id(UUID.randomUUID().toString()).address(address).itemList(item).build();
        orderRepository.save(order);

        user.getOrders().add(order);
        userRepository.save(user);

        shoppingCartServiceImpl.deleteItemWithShoppingCart(user.getId(), itemIds);
        return order;
    }

    @Override
    public Order getOrder(User user, String orderId) {
        return orderRepository.findByIdAndUser_Id(user.getId(), orderId);
    }
}
