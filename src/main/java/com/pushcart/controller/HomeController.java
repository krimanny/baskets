package com.pushcart.controller;

import com.pushcart.model.Basket;
import com.pushcart.requests.GuestVo;
import com.pushcart.requests.ItemVo;
import com.pushcart.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    BasketService basketService;


    @GetMapping("/")
    public String homePage(GuestVo guestVo) {
        return "index";
    }

    @PostMapping("/cart")
    public String submitName(GuestVo guestVo, Model model) {
        model.addAttribute("baskets", basketService.getAllBasket());
        return "cart";
    }

    @GetMapping("/cart")
    public String viewBaskets(GuestVo guestVo, Model model) {
        List<Basket> listBasket = basketService.getAllBasket();
        BigDecimal totalPrice = new BigDecimal(0);
        for(Basket basket : listBasket){
            totalPrice = totalPrice.add(new BigDecimal(String.valueOf(basket.getTotalPrice())));
        }
        model.addAttribute("baskets", listBasket);
        model.addAttribute("basketTotalPrice", totalPrice);
        return "cart";
    }

    @GetMapping("/cart/basket/{id}")
    public String getBasket(@PathVariable Long id,  Model model, ItemVo itemVo) {
        Optional<Basket> basket = basketService.getBasket(id);
        model.addAttribute("oBasket",basket.get());
        return "basket";
    }
}
