package com.nopaldev.artesanos.facades;

import com.nopaldev.artesanos.controllers.forms.CustomerRegistrationForm;

import javax.validation.Valid;

public interface CustomerFacade {
    void register(@Valid final CustomerRegistrationForm registerInfo);
}
