package com.crazzy.junit.api;

import com.crazzy.junit.entity.Item;
import com.crazzy.junit.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemApi {

    private final ItemService itemService;

    public ItemApi(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Item getItem() {
        return new Item(1L, "Bread", 10, 28);
    }

    @GetMapping("/service")
    public Item getItemFromService() {
        return itemService.getItem();
    }

    @GetMapping("/{id}")
    public Item findAll(@PathVariable String id) {
        return itemService.findItem(Long.valueOf(id));
    }

    @GetMapping("/all")
    public List<Item> findAll() {
        return itemService.findAll();
    }
}
