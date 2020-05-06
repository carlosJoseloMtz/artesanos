package com.nopaldev.artesanos.core.strategies.impl;

import com.nopaldev.artesanos.core.models.commerce.ProductModel;
import com.nopaldev.artesanos.core.models.commerce.StockModel;
import com.nopaldev.artesanos.core.strategies.StockAvailabilityStrategy;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component("stockAvailabilityStrategy")
public class DefaultStockAvailabilityStrategy implements StockAvailabilityStrategy {

    @Override
    public long calculateAvailability(@NotNull final ProductModel product) {
        if (product.getStocks() == null || product.getStocks().isEmpty()) {
            return 0;
        }

        // NOTICE: you can limit here to sell based on the store configuration or whatever you want
        // so that you can sell locally only :)
        return product.getStocks().parallelStream()
                .mapToLong(StockModel::getQuantity)
                .sum();
    }   
}
