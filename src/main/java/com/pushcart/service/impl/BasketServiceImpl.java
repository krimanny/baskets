package com.pushcart.service.impl;

import com.pushcart.model.Item;
import com.pushcart.repository.BasketRepository;
import com.pushcart.model.Basket;
import com.pushcart.repository.ItemRepository;
import com.pushcart.requests.ItemVo;
import com.pushcart.service.BasketService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    private static final Log log = LogFactory.getLog(BasketServiceImpl.class);

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Basket> getAllBasket() {
        return basketRepository.findAll();
    }

    @Override
    public Basket createNewBasket() {
        return basketRepository.save(new Basket());
    }

    @Override
    public Optional<Basket> getBasket(Long id) {
        Optional<Basket> basket =  basketRepository.findById(id);
        log.info(basket.toString());
        return basket;
    }

    @Override
    public void deleteBasket(Long id) {
        itemRepository.deleteAllByBasketId(id);
        basketRepository.deleteById(id);
    }

    @Override
    public void addItemToBasket(ItemVo item, Long id) {
        Item it = new Item(item.getName(), item.getPrice(), id);
        itemRepository.saveAndFlush(it);
        Optional<Basket> basket =  basketRepository.findById(id);
        BigDecimal totalPrice = basket.get().getTotalPrice();
        basket.get().setTotalPrice(totalPrice.add(item.getPrice()));
        basketRepository.saveAndFlush(basket.get());
        log.info(it.toString());
    }

    @Override
    public void removeItemToBasket(Long id, Long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        Optional<Basket> basket =  basketRepository.findById(id);
        BigDecimal totalPrice = basket.get().getTotalPrice();
        basket.get().setTotalPrice(totalPrice.subtract(item.get().getPrice()));
        basketRepository.saveAndFlush(basket.get());
        itemRepository.deleteById(itemId);
        log.info(basket.toString());
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }
}
