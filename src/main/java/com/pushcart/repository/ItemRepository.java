package com.pushcart.repository;

import com.pushcart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ItemRepository extends JpaRepository<Item, Long>{

    @Transactional
    @Modifying
    @Query(value ="delete from Item i where i.basketId = :id")
    public void deleteAllByBasketId(Long id);

}
