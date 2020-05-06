package com.nopaldev.artesanos.controllers.commerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    private static final Logger LOG = LoggerFactory.getLogger(CartController.class);

    @PostMapping("/current/add/{pCode}")
    private void addToCart(@PathVariable("pCode") final String productCode,
                           @RequestParam("quantity") final long quantity) {
        LOG.info("Trying to add product [{}] with quantity [{}]", productCode, quantity);
    }
}
