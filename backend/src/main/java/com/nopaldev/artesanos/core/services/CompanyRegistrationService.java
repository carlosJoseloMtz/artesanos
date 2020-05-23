package com.nopaldev.artesanos.core.services;

import com.nopaldev.artesanos.core.services.dtos.CompanyRegistrationDTO;

/**
 * Handles the registration of the company.
 */
public interface CompanyRegistrationService {

    /**
     * Registers the company and asynchronously sends the email to the customer to validate the email.
     *
     * @param dto The data of the company to be registered.
     */
    void register(final CompanyRegistrationDTO dto);
}
