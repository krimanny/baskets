package com.pushcart.controller;

import com.pushcart.facade.BasketFacade;
import com.pushcart.model.Basket;
import com.pushcart.model.Item;
import com.pushcart.requests.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BasketController {

    @Autowired
    BasketFacade pusCartfacade;

    @GetMapping("/baskets")
    public List<Basket> getAllBasket() {
        return pusCartfacade.getAllBasket();
    }

    @PostMapping("/basket")
    @ResponseStatus(HttpStatus.CREATED)
    public Basket createBasket() {
        return pusCartfacade.createNewBasket();
    }

    @GetMapping("/basket/{id}")
    public Optional<Basket> getBasket(@PathVariable Long id) {
        return pusCartfacade.getBasket(id);
    }

    @DeleteMapping("/basket/{id}")
    public void deleteBasket(@PathVariable Long id) {
        pusCartfacade.deleteBasket(id);
    }

    @PostMapping("/basket/{id}/addItem")
    public void addItemToBasket(@RequestBody ItemVo item, @PathVariable Long id) {
        pusCartfacade.addItemToBasket(item, id);
    }

    @PutMapping("/basket/{id}/{itemId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeItemToBasket(@PathVariable Long id, @PathVariable Long itemId){
        pusCartfacade.removeItemToBasket(id, itemId);
    }

    @GetMapping("/items")
    public List<Item> getAllItem(){
        return pusCartfacade.getAllItem();
    }
}
