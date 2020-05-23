package com.nopaldev.artesanos.facades;


import com.nopaldev.artesanos.controllers.forms.CompanyRegistrationForm;

/**
 * Handles all the direct transactions with the company.
 */
public interface CompanyFacade {

    /**
     * Registers the customer into the system.
     *
     * @param registrationForm The registration form.
     */
    void registerCompany(final CompanyRegistrationForm registrationForm);
}