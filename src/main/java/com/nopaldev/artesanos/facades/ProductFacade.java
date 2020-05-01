package com.nopaldev.artesanos.facades;

import com.nopaldev.artesanos.facades.dtos.ProductDTO;

import java.util.Collection;

public interface ProductFacade {
    void createProduct(final ProductDTO product);

    ProductDTO getProductForCode(final String code);

    Collection<ProductDTO> getProductsForCraftsman(final Long craftsmanId);
}
