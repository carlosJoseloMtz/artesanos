package mx.nopal.commerce.customers.facades;

import mx.nopal.commerce.customers.controllers.forms.CompanyRegistrationForm;
import mx.nopal.commerce.customers.exceptions.ItemAlreadyExistsException;

public interface CompanyFacade {
    void register(final CompanyRegistrationForm registrationInfo) throws ItemAlreadyExistsException;
}
