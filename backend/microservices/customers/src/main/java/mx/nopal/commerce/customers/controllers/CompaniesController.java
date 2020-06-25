package mx.nopal.commerce.customers.controllers;

import mx.nopal.commerce.customers.controllers.forms.CompanyRegistrationForm;
import mx.nopal.commerce.customers.exceptions.ItemAlreadyExistsException;
import mx.nopal.commerce.customers.facades.CompanyFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Resource
    private CompanyFacade companyFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void register(@Valid @RequestBody final CompanyRegistrationForm form) throws ItemAlreadyExistsException {
        // TODO: validate the form?
        companyFacade.register(form);
    }
}
