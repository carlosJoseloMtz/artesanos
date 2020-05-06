package com.nopaldev.artesanos.facades.impl;

import com.nopaldev.artesanos.core.services.CustomerRegistrationService;
import com.nopaldev.artesanos.core.services.dtos.CompanyRegistrationDTO;
import com.nopaldev.artesanos.core.services.dtos.UserRegistrationDTO;
import com.nopaldev.artesanos.facades.CompanyFacade;
import com.nopaldev.artesanos.facades.dtos.RegisterDTO;
import com.nopaldev.artesanos.facades.dtos.SellerRegisterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("companyFacade")
public class DefaultCompanyFacade extends DefaultCustomerFacade implements CompanyFacade {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCompanyFacade.class);

    @Autowired
    public DefaultCompanyFacade(final CustomerRegistrationService companyRegistrationService) {
        super(companyRegistrationService);
    }

    @Override
    protected UserRegistrationDTO mapRegisterInfo(final RegisterDTO registerInfo) {

        if (registerInfo instanceof SellerRegisterDTO) {
            final var registerCompany = (SellerRegisterDTO) registerInfo;
            LOG.info("Registering company with name [{}]", registerCompany.getCompanyName());
            final var company = new CompanyRegistrationDTO();
            company.setCompanyName(registerCompany.getCompanyName());
            company.setName(registerCompany.getName());
            company.setPassword(registerCompany.getPassword());
            company.setLastName(registerCompany.getLastName());
            return company;
        }

        LOG.warn("Using company facade for registering a customer instead of a company");

        return super.mapRegisterInfo(registerInfo);
    }
}
