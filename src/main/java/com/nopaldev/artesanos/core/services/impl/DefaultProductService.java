package com.nopaldev.artesanos.core.services.impl;

import com.nopaldev.artesanos.core.exceptions.ItemNotFoundException;
import com.nopaldev.artesanos.core.models.commerce.ProductModel;
import com.nopaldev.artesanos.core.respositories.CraftsmanRepository;
import com.nopaldev.artesanos.core.respositories.ProductRepository;
import com.nopaldev.artesanos.core.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CraftsmanRepository craftsmanRepository;

    @Autowired
    public DefaultProductService(final ProductRepository productRepository,
                                 final CraftsmanRepository craftsmanRepository) {
        this.productRepository = productRepository;
        this.craftsmanRepository = craftsmanRepository;
    }

    @Override
    public ProductModel getProductForCode(final String code) {
        Assert.notNull(code, "Code should not be null");
        Assert.isTrue(!code.isBlank(), "Code should not be empty");
        final var foundProd = getProductRepository().findProductModelByCode(code);
        if (foundProd == null) {
            throw new ItemNotFoundException(String.format("Product with code %s not found", code));
        }

        return foundProd;
    }

    @Override
    public void createProduct(final ProductModel product) {
        Assert.notNull(product, "Product should not be null");
        getProductRepository().save(product);
    }

    @Override
    public List<ProductModel> getProductsForCraftsman(final Long craftsmanId) {
        Assert.notNull(craftsmanId, "Craftsman id can not be null");
        Assert.isTrue(craftsmanId > 0, "Craftsman id has to be greater than 0");

        final var foundCraftsman = getCraftsmanRepository().findById(craftsmanId);

        if (foundCraftsman.isEmpty()) {
            throw new ItemNotFoundException(String.format("Craftsman with id %s not found", craftsmanId));
        }

        final var craftsman = foundCraftsman.get();
        return getProductRepository().findProductModelsByCraftsman(craftsman);
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public CraftsmanRepository getCraftsmanRepository() {
        return craftsmanRepository;
    }
}
