package com.nopaldev.artesanos.controllers;

import com.nopaldev.artesanos.facades.ProductFacade;
import com.nopaldev.artesanos.facades.dtos.ProductDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Resource
    private ProductFacade productFacade;

    @GetMapping("/{code}")
    private Mono<ProductDTO> getProductForCode(@PathVariable final String code) {
        return Mono.just(productFacade.getProductForCode(code));
    }
}
