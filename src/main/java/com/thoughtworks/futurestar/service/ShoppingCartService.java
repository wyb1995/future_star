package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.entity.Item;

import java.util.List;

public interface ShoppingCartService {
    List<Item> getShoppingCart(String user_id);

    List<Item> addItemToShoppingCart(String user_id, String item_id);

    void deleteItemWithShoppingCart(String user_id, List<String> itemIds);
}
