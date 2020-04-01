package com.crazzy.junit.service.impl;

import com.crazzy.junit.entity.Item;
import com.crazzy.junit.repository.ItemRepository;
import com.crazzy.junit.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getItem() {
        return new Item(1L, "item1", 10, 12);
    }

    @Override
    public Item findItem(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public List<Item> findAll() {
        List<Item> all = itemRepository.findAll();

        for(Item item: all) {
            item.setValue(item.getPrice() * item.getQuantity());
        }

        return all;
    }
}
