package com.nopaldev.artesanos.facades.impl;

import com.nopaldev.artesanos.core.services.CartService;
import com.nopaldev.artesanos.core.services.ProductService;
import com.nopaldev.artesanos.facades.CartFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cartFacade")
public class DefaultCartFacade implements CartFacade {

    private final ProductService productService;
    private final CartService cartService;

    @Autowired
    public DefaultCartFacade(final ProductService productService,
                             final CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @Override
    public void addToCart(final String productCode, final long quantity) {
        final var product = getProductService().getProductForCode(productCode);

        // TODO: retrieved the modification to the upper layer
        getCartService().addEntryToCart(null, product, quantity);
    }

    public ProductService getProductService() {
        return productService;
    }

    public CartService getCartService() {
        return cartService;
    }
}
