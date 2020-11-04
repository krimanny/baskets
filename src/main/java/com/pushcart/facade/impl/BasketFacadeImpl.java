package com.pushcart.facade.impl;

import com.pushcart.facade.BasketFacade;
import com.pushcart.model.Basket;
import com.pushcart.model.Item;
import com.pushcart.requests.ItemVo;
import com.pushcart.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BasketFacadeImpl implements BasketFacade {

    @Autowired
    BasketService basketService;

    @Override
    public List<Basket> getAllBasket() {
        return basketService.getAllBasket();
    }

    @Override
    public Basket createNewBasket() {
        return basketService.createNewBasket();
    }

    @Override
    public Optional<Basket> getBasket(Long id) {
        return basketService.getBasket(id);
    }

    @Override
    public void deleteBasket(Long id) {
        basketService.deleteBasket(id);
    }

    @Override
    public void addItemToBasket(ItemVo item, Long id) {
        basketService.addItemToBasket(item, id);
    }

    @Override
    public void removeItemToBasket(Long id, Long itemId) {
        basketService.removeItemToBasket(id, itemId);
    }

    @Override
    public List<Item> getAllItem() {
        return basketService.getAllItem();
    }
}
