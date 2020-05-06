package com.nopaldev.artesanos.core.strategies.impl;

import com.nopaldev.artesanos.core.models.commerce.CartEntryModel;
import com.nopaldev.artesanos.core.models.commerce.CartModel;
import com.nopaldev.artesanos.core.strategies.CartEntryStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Optional;


@Component("cartEntryStrategy")
public class DefaultCartEntryStrategy implements CartEntryStrategy {

    @Override
    public Optional<CartEntryModel> findEntryByProduct(final CartModel cart, final String productCode) {
        Assert.notNull(cart, "Cart can not be null");
        Assert.notNull(productCode, "Product code can not be null");
        Assert.isTrue(!productCode.isBlank(), "Product code can not be blank");

        if (cart.getEntries() == null || cart.getEntries().isEmpty()) {
            return Optional.empty();
        }


        return cart.getEntries().parallelStream()
                .filter(e -> e.getProduct().getCode().equals(productCode))
                .findAny();
    }

}
