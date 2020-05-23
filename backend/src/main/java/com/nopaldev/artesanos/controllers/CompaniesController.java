package com.nopaldev.artesanos.controllers;

import com.nopaldev.artesanos.facades.CompanyFacade;
import com.nopaldev.artesanos.facades.ProductFacade;
import com.nopaldev.artesanos.facades.dtos.ProductDTO;
import com.nopaldev.artesanos.controllers.forms.CompanyRegistrationForm;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Resource
    private ProductFacade productFacade;

    @Resource
    private CompanyFacade companyFacade;

    @PostMapping
    private void registerCompany(@Valid @RequestBody final CompanyRegistrationForm registrationForm) {
        companyFacade.registerCompany(registrationForm);
    }

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
