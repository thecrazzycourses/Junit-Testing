package com.crazzy.junit.service;

import com.crazzy.junit.entity.Item;

import java.util.List;

public interface ItemService {
    Item getItem();

    Item findItem(Long id);

    List<Item> findAll();
}
