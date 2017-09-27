package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.dto.OrderDTO;
import com.thoughtworks.futurestar.entity.Order;
import com.thoughtworks.futurestar.entity.User;

public interface OrderService {
    Order createOrder(User user, OrderDTO orderDTO);

    Order getOrder(User user, String order_id);
}
