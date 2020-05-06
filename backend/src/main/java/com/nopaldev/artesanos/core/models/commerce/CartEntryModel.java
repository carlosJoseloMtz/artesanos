package com.nopaldev.artesanos.core.models.commerce;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CartEntryModel extends AbstractEntryModel {
    @ManyToOne
    private CartModel cart;

    public CartModel getCart() {
        return cart;
    }

    public void setCart(CartModel cart) {
        this.cart = cart;
    }
}
