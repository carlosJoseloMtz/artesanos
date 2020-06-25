package mx.nopal.commerce.customers.facades.impl;

import mx.nopal.commerce.customers.controllers.forms.CompanyRegistrationForm;
import mx.nopal.commerce.customers.exceptions.ItemAlreadyExistsException;
import mx.nopal.commerce.customers.facades.CompanyFacade;
import mx.nopal.commerce.customers.model.CompanyModel;
import mx.nopal.commerce.customers.services.CompanyService;

public class DefaultCompanyFacade implements CompanyFacade {

    private final CompanyService companyService;

    public DefaultCompanyFacade(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public void register(final CompanyRegistrationForm registrationInfo) throws ItemAlreadyExistsException {
        final var username = registrationInfo.getEmail();
        if (customerExists(username)) {
            throw new ItemAlreadyExistsException("Username is already registered");
        }
        final var newCompany = mapCompanyFromInput(registrationInfo);
        getCompanyService().register(newCompany);
    }

    private boolean customerExists(final String username) {
        return getCompanyService().getUserForUsername(username) != null;
    }

    private CompanyModel mapCompanyFromInput(final CompanyRegistrationForm form) {
        final var company = new CompanyModel();

        company.setCompanyName(form.getCompanyName());
        company.setPassword(form.getPassword());
        company.setUsername(form.getEmail());

        return company;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }
}
