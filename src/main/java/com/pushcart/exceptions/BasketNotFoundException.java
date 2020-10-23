package com.pushcart.exceptions;

public class BasketNotFoundException extends RuntimeException {

    public BasketNotFoundException(Long id) {
        super("Basket not found : " + id);
    }
}
