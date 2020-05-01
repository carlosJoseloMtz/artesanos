package com.nopaldev.artesanos.facades.impl;

import com.nopaldev.artesanos.core.models.commerce.ProductModel;
import com.nopaldev.artesanos.core.services.ProductService;
import com.nopaldev.artesanos.facades.ProductFacade;
import com.nopaldev.artesanos.facades.converters.Converter;
import com.nopaldev.artesanos.facades.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collection;


@Component
public class DefaultProductFacade implements ProductFacade {

    private final ProductService productService;
    private final Converter<ProductModel, ProductDTO> productConverter;

    @Autowired
    public DefaultProductFacade(final ProductService productService,
                                final Converter<ProductModel, ProductDTO> baseProductConverter) {
        this.productService = productService;
        this.productConverter = baseProductConverter;
    }

    @Override
    public void createProduct(final ProductDTO product) {
        Assert.notNull(product, "Product can not be null");
        final var nProd = new ProductModel();
        nProd.setCode(product.getCode());
        nProd.setName(product.getName());
        nProd.setDescription(product.getDescription());

        // TODO: setup the craftsman from the session

        getProductService().createProduct(nProd);
    }

    @Override
    public ProductDTO getProductForCode(final String code) {
        Assert.notNull(code, "Code should not be null");

        return getProductConverter().convert(getProductService().getProductForCode(code));
    }

    @Override
    public Collection<ProductDTO> getProductsForCraftsman(final Long craftsmanId) {
        Assert.notNull(craftsmanId, "Craftsman id can not be null");

        final var prods = getProductService().getProductsForCraftsman(craftsmanId);

        return getProductConverter().convertAll(prods);
    }

    public ProductService getProductService() {
        return productService;
    }

    public Converter<ProductModel, ProductDTO> getProductConverter() {
        return productConverter;
    }
}
