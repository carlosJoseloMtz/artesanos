package com.nopaldev.artesanos.core.strategies;

import com.nopaldev.artesanos.core.models.commerce.CartEntryModel;
import com.nopaldev.artesanos.core.models.commerce.CartModel;

import java.util.Optional;

public interface CartEntryStrategy {

    Optional<CartEntryModel> findEntryByProduct(final CartModel cart, final String productCode);
}
