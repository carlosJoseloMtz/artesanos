package com.nopaldev.artesanos.core.services.impl;

import com.nopaldev.artesanos.core.models.users.CraftsmanModel;
import com.nopaldev.artesanos.core.respositories.CraftsmanRepository;
import com.nopaldev.artesanos.core.respositories.CustomerRepository;
import com.nopaldev.artesanos.core.services.EmailService;
import com.nopaldev.artesanos.core.services.dtos.CompanyRegistrationDTO;
import com.nopaldev.artesanos.core.services.dtos.UserRegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("companyRegistrationService")
public class DefaultCompanyRegistrationService extends DefaultCustomerRegistrationService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCompanyRegistrationService.class);

    private final CraftsmanRepository craftsmanRepository;


    // TODO: find a best practice for extending services that do not require including
    @Autowired
    public DefaultCompanyRegistrationService(final CustomerRepository customerRepository,
                                             final EmailService emailService,
                                             final CraftsmanRepository craftsmanRepository) {
        super(customerRepository, emailService);
        this.craftsmanRepository = craftsmanRepository;
    }

    protected void createCustomer(final UserRegistrationDTO user) {
        if (user instanceof CompanyRegistrationDTO) {
            final var company = (CompanyRegistrationDTO) user;

            LOG.debug("Creating company with name [{}]", company.getCompanyName());

            final var customer = new CraftsmanModel();
            customer.setName(company.getName());
            customer.setLastName(company.getLastName());
            // TODO: hash the password
            customer.setPassword(company.getPassword());
            customer.setCompanyName(company.getCompanyName());
            getCraftsmanRepository().save(customer);
        }
    }


    public CraftsmanRepository getCraftsmanRepository() {
        return craftsmanRepository;
    }
}
