package com.nopaldev.artesanos.facades.impl;

import com.nopaldev.artesanos.core.services.CompanyRegistrationService;
import com.nopaldev.artesanos.core.services.dtos.CompanyRegistrationDTO;
import com.nopaldev.artesanos.facades.CompanyFacade;
import com.nopaldev.artesanos.controllers.forms.CompanyRegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component("companyFacade")
public class DefaultCompanyFacade implements CompanyFacade {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCompanyFacade.class);

    private final CompanyRegistrationService companyRegistrationService;

    @Autowired
    public DefaultCompanyFacade(final CompanyRegistrationService companyRegistrationService) {
        this.companyRegistrationService = companyRegistrationService;
    }

    /**
     * @see CompanyFacade#registerCompany(CompanyRegistrationForm).
     */
    @Override
    public void registerCompany(final CompanyRegistrationForm registrationForm) {
        Assert.notNull(registrationForm, "Form can not be null");
        final var dto = mapToDto(registrationForm);
        getCompanyRegistrationService().register(dto);
    }

    protected CompanyRegistrationDTO mapToDto(final CompanyRegistrationForm registrationForm) {
        final var dto = new CompanyRegistrationDTO();
        dto.setPassword(registrationForm.getPassword());
        dto.setName(registrationForm.getName());
        dto.setLastName(registrationForm.getLastName());
        dto.setCompanyName(registrationForm.getCompanyName());
        dto.setEmail(registrationForm.getEmail());
        return dto;
    }

    public CompanyRegistrationService getCompanyRegistrationService() {
        return companyRegistrationService;
    }
}
