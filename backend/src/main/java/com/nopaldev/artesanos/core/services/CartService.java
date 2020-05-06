package com.nopaldev.artesanos.core.services;

import com.nopaldev.artesanos.core.models.commerce.CartModel;
import com.nopaldev.artesanos.core.models.commerce.ProductModel;

public interface CartService {

    long addEntryToCart(final CartModel cart, final ProductModel product, final long quantity);
}
