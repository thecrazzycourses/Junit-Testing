package com.crazzy.junit.service.impl;

import com.crazzy.junit.entity.Item;
import com.crazzy.junit.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

    @InjectMocks
    private ItemServiceImpl itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void findAllItems() {

        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(1L, "item1", 10, 12),
                new Item(2L, "item2", 12, 24)
        ));

        List<Item> items = itemService.findAll();

        assertEquals(120, items.get(0).getValue());
        assertEquals(288, items.get(1).getValue());
    }
}