package com.nopaldev.artesanos.core.strategies;

import com.nopaldev.artesanos.core.models.commerce.ProductModel;

import javax.validation.constraints.NotNull;

public interface StockAvailabilityStrategy {

    long calculateAvailability(@NotNull final ProductModel product);
}
