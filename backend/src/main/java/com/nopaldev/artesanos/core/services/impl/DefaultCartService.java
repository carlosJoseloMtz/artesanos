package com.nopaldev.artesanos.core.services.impl;

import com.nopaldev.artesanos.core.models.commerce.CartEntryModel;
import com.nopaldev.artesanos.core.models.commerce.CartModel;
import com.nopaldev.artesanos.core.models.commerce.ProductModel;
import com.nopaldev.artesanos.core.respositories.CartEntryRepository;
import com.nopaldev.artesanos.core.services.CartService;
import com.nopaldev.artesanos.core.strategies.CartEntryStrategy;
import com.nopaldev.artesanos.core.strategies.StockAvailabilityStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("cartService")
public class DefaultCartService implements CartService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCartService.class);

    private final StockAvailabilityStrategy stockAvailabilityStrategy;
    private final CartEntryStrategy cartEntryStrategy;
    private final CartEntryRepository cartEntryRepository;

    @Autowired
    public DefaultCartService(final StockAvailabilityStrategy stockAvailabilityStrategy,
                              final CartEntryStrategy cartEntryStrategy,
                              final CartEntryRepository cartEntryRepository) {
        this.stockAvailabilityStrategy = stockAvailabilityStrategy;
        this.cartEntryStrategy = cartEntryStrategy;
        this.cartEntryRepository = cartEntryRepository;
    }

    @Override
    public long addEntryToCart(final CartModel cart, final ProductModel product, final long quantity) {
        Assert.notNull(cart, "Cart can not be null");
        Assert.notNull(product, "Product can not be null");
        Assert.isTrue(quantity > 0, "Quantity has to be greater than 0");

        final var availability = getStockAvailabilityStrategy().calculateAvailability(product);

        return getCartEntryStrategy().findEntryByProduct(cart, product.getCode())
                .map(cartEntryModel -> mergeEntry(availability, quantity, cartEntryModel))
                .orElseGet(() -> createEntry(cart, product, quantity, availability));
    }

    protected long createEntry(final CartModel cart,
                               final ProductModel product,
                               final long quantity,
                               final long availability) {

        final var entry = new CartEntryModel();
        entry.setProduct(product);
        entry.setCart(cart);
        // TODO: find the price for the product
        entry.setBasePrice(null);

        getCartEntryRepository().save(entry);
        return 0;
    }

    protected long mergeEntry(final long availability, final long requestedQuantity, final CartEntryModel entry) {
        final var previous = entry.getQuantity();
        final var pCode = entry.getProduct().getCode();

        // TODO: find a better way to do all this
        if (availability == 0) {
            LOG.warn(
                    "Entry [{}] has previous quantity [{}], but there's 0 availability, entry will be removed",
                    pCode, previous);

            getCartEntryRepository().delete(entry);
            return previous * -1;
        }

        final var newQuantity = previous + requestedQuantity;

        if (availability < newQuantity) {
            final var actualAvailable = previous - availability;

            LOG.warn("Entry [{}] requires [{}], but there's only [{}] available",
                    pCode, newQuantity, availability);

            entry.setQuantity(availability);
            getCartEntryRepository().save(entry);
            return actualAvailable;
        }

        entry.setQuantity(newQuantity);
        getCartEntryRepository().save(entry);
        return requestedQuantity;
    }

    public StockAvailabilityStrategy getStockAvailabilityStrategy() {
        return stockAvailabilityStrategy;
    }

    public CartEntryStrategy getCartEntryStrategy() {
        return cartEntryStrategy;
    }

    public CartEntryRepository getCartEntryRepository() {
        return cartEntryRepository;
    }
}
