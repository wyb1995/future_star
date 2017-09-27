package com.thoughtworks.futurestar.service.Impl;

import com.thoughtworks.futurestar.entity.Item;
import com.thoughtworks.futurestar.repository.ItemRepository;
import com.thoughtworks.futurestar.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional
    public Item create(Item item) {
        item.setId(UUID.randomUUID().toString());
        return itemRepository.save(item);
    }
}
