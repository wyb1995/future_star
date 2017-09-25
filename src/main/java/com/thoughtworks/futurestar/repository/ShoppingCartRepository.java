package com.thoughtworks.futurestar.repository;

import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String>{
    ShoppingCart findAllByUser_id(String user_id);
}
