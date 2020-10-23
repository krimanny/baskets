package com.pushcart.service;

import com.pushcart.model.Basket;
import com.pushcart.model.Item;
import com.pushcart.requests.ItemVo;

import java.util.List;
import java.util.Optional;

public interface BasketService {

    public List<Basket> getAllBasket();

    public void createNewBasket();

    public Optional<Basket> getBasket(Long id);

    public void deleteBasket(Long id);

    public void addItemToBasket(ItemVo item, Long id);

    public void removeItemToBasket(Long id, Long itemId);

    public List<Item> getAllItem();
}
