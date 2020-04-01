package com.crazzy.junit.repository;

import com.crazzy.junit.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
