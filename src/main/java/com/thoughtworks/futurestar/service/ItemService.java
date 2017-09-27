package com.thoughtworks.futurestar.service;

import com.thoughtworks.futurestar.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();

    Item create(Item item);

}

