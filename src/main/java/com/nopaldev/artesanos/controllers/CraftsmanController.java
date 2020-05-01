package com.nopaldev.artesanos.controllers;

import com.nopaldev.artesanos.facades.ProductFacade;
import com.nopaldev.artesanos.facades.dtos.ProductDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

@RestController
@RequestMapping("/craftsman")
public class CraftsmanController {

    @Resource
    private ProductFacade productFacade;


    @GetMapping("/{craftsmanId}/products")
    private Flux<ProductDTO> getProductsByCraftsman(@PathVariable(name = "craftsmanId") final Long craftsmanId) {
        return Flux.fromIterable(productFacade.getProductsForCraftsman(craftsmanId));
    }

    @PostMapping(value = "/{craftsmanId}/products",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    private void createProductForCurrentCraftsman(@RequestBody ProductDTO product) {
        productFacade.createProduct(product);
    }


}
