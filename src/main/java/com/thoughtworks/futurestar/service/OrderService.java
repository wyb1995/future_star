package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.entity.Order;
import com.thoughtworks.futurestar.entity.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, List<String> itemIds);

    Order getOrder(User user, String order_id);
}
