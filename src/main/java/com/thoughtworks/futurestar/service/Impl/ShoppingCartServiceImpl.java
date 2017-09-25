package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.entity.ShoppingCart;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.repository.ItemRepository;
import com.thoughtworks.futurestar.repository.ShoppingCartRepository;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Item> getShoppingCart(String user_id) {
        User user = userRepository.findOne(user_id);
        ShoppingCart shoppingCart = shoppingCartRepository.findAllByUser_id(user_id);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setId(UUID.randomUUID().toString());
            shoppingCart.setUser(user);
            shoppingCartRepository.save(shoppingCart);
            return null;
        }

        List<Item> itemList = shoppingCart.getItemList();
//        List<Item> itemList = shoppingCartRepository.findAllById(shoppingCart.getId());

        return itemList;
    }

    @Override
    public List<Item> addItemToShoppingCart(String user_id, String item_id) {
        User user = userRepository.findOne(user_id);
        Item item = itemRepository.findOne(item_id);
        ShoppingCart shoppingCart = shoppingCartRepository.findAllByUser_id(user_id);
        List<Item> items = new ArrayList<>();
        if (shoppingCart == null) {
            items.add(item);
            shoppingCart = new ShoppingCart();
            shoppingCart.setId(UUID.randomUUID().toString());
            shoppingCart.setUser(user);
            shoppingCart.setItemList(items);
            shoppingCartRepository.save(shoppingCart);

            return items;
        }
        items = shoppingCart.getItemList();
        items.add(item);
        shoppingCart.setItemList(items);
        shoppingCartRepository.save(shoppingCart);
        return items;
    }
}
