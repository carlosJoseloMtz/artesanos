package com.nopaldev.artesanos.core.services.impl;

import com.nopaldev.artesanos.core.models.users.CustomerModel;
import com.nopaldev.artesanos.core.respositories.CustomerRepository;
import com.nopaldev.artesanos.core.services.CustomerRegistrationService;
import com.nopaldev.artesanos.core.services.EmailService;
import com.nopaldev.artesanos.core.services.dtos.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerRegistrationService")
public class DefaultCustomerRegistrationService implements CustomerRegistrationService {

    private final CustomerRepository customerRepository;
    private final EmailService emailService;

    @Autowired
    public DefaultCustomerRegistrationService(final CustomerRepository customerRepository,
                                              final EmailService emailService) {
        this.customerRepository = customerRepository;
        this.emailService = emailService;
    }

    @Override
    public void register(final UserRegistrationDTO user) {
        createCustomer(user);
        getEmailService().send("welcome-email", null);
        // TODO: send email registration to validate the email
    }

    protected void createCustomer(final UserRegistrationDTO user) {
        final var customer = new CustomerModel();
        customer.setName(user.getName());
        customer.setLastName(user.getLastName());
        // TODO: hash the password
        customer.setPassword(user.getPassword());
        getCustomerRepository().save(customer);
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public EmailService getEmailService() {
        return emailService;
    }
}
