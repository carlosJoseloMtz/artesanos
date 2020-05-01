package com.nopaldev.artesanos.core.services;

import com.nopaldev.artesanos.core.models.commerce.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel getProductForCode(final String code);

    void createProduct(final ProductModel product);

    List<ProductModel> getProductsForCraftsman(final Long craftsmanId);
}
