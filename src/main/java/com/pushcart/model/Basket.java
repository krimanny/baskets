package com.pushcart.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_BASKET")
public class Basket implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "BASKET_ID")
    private Long basketId;

    @OneToMany(targetEntity = Item.class, fetch = FetchType.EAGER, mappedBy="basketId")
    private List<Item> items = new ArrayList<>();

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public Basket() {
        super();
    }

    public Long getId() {
        return basketId;
    }

    public void setId(Long id) {
        this.basketId = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setTotalPrice(BigDecimal totalPrice){
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice(){
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketId=" + basketId +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
