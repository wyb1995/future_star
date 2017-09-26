package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.entity.ShoppingCart;
import com.thoughtworks.futurestar.entity.User;
import com.thoughtworks.futurestar.exception.InvalidCredentialException;
import com.thoughtworks.futurestar.repository.ItemRepository;
import com.thoughtworks.futurestar.repository.ShoppingCartRepository;
import com.thoughtworks.futurestar.repository.UserRepository;
import com.thoughtworks.futurestar.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        if (user == null) {
            throw new InvalidCredentialException("no login");
        }
        ShoppingCart shoppingCart = shoppingCartRepository.findAllByUser_id(user_id);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setId(UUID.randomUUID().toString());
            shoppingCart.setUser(user);
            shoppingCartRepository.save(shoppingCart);
            return shoppingCart.getItemList();
        }

        return shoppingCart.getItemList();
    }

    @Override
    public List<Item> addItemToShoppingCart(String user_id, String item_id) {
        User user = userRepository.findOne(user_id);
        if (user == null) {
            throw new InvalidCredentialException("no login");
        }
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

    @Override
    public void deleteItemWithShoppingCart(String user_id, List<String> itemIds) {
        User user = userRepository.findOne(user_id);
        if (user == null) {
            throw new InvalidCredentialException("no login");
        }
        ShoppingCart shoppingCart = shoppingCartRepository.findAllByUser_id(user_id);
        List<Item> items = shoppingCart.getItemList().stream()
                .filter(item -> !itemIds.contains(item.getId())).collect(Collectors.toList());
        shoppingCart.setItemList(items);
        shoppingCartRepository.save(shoppingCart);
    }
}
