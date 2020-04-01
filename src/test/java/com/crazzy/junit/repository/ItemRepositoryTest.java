package com.crazzy.junit.repository;

import com.crazzy.junit.entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class ItemRepositoryTest {

    private ItemRepository itemRepository;

    @Autowired
    ItemRepositoryTest(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Test
    public void testFindAll() {
        List<Item> all = itemRepository.findAll();

        assertEquals(10, all.size());
    }

}