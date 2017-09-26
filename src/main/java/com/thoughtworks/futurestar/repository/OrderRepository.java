package com.thoughtworks.futurestar.repository;

import com.thoughtworks.futurestar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String>{
}
