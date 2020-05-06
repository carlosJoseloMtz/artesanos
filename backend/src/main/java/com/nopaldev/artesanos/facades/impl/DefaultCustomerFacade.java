package com.nopaldev.artesanos.facades.impl;

import com.nopaldev.artesanos.core.services.CustomerRegistrationService;
import com.nopaldev.artesanos.core.services.dtos.UserRegistrationDTO;
import com.nopaldev.artesanos.facades.CustomerFacade;
import com.nopaldev.artesanos.facades.dtos.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.validation.Valid;

public class DefaultCustomerFacade implements CustomerFacade {

    private final CustomerRegistrationService customerRegistrationService;

    @Autowired
    public DefaultCustomerFacade(final CustomerRegistrationService customerRegistrationService) {
        this.customerRegistrationService = customerRegistrationService;
    }

    protected void validateRegisterData(final RegisterDTO registerInfo) {
        Assert.notNull(registerInfo, "Register information can not be null");
        Assert.isTrue(registerInfo.getPassword().equals(registerInfo.getRepeatedPassword()), "Passwords have to match");
    }

    @Override
    public void register(@Valid final RegisterDTO registerInfo) {
        validateRegisterData(registerInfo);

        // TODO: validate password strength
        final var customer = mapRegisterInfo(registerInfo);
        getCustomerRegistrationService().register(customer);
    }

    protected UserRegistrationDTO mapRegisterInfo(final RegisterDTO registerInfo) {
        final var customer = new UserRegistrationDTO();
        customer.setName(registerInfo.getName());
        customer.setLastName(registerInfo.getLastName());
        customer.setPassword(registerInfo.getPassword());

        return customer;
    }

    public CustomerRegistrationService getCustomerRegistrationService() {
        return customerRegistrationService;
    }
}
