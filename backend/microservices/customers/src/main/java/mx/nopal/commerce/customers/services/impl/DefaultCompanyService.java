package mx.nopal.commerce.customers.services.impl;

import mx.nopal.commerce.customers.model.CompanyModel;
import mx.nopal.commerce.customers.repositories.CompanyRepository;
import mx.nopal.commerce.customers.services.CompanyService;

public class DefaultCompanyService extends DefaultUserService<CompanyModel> implements CompanyService {

    public DefaultCompanyService(final CompanyRepository companyRepository) {
        super(companyRepository);
    }

    @Override
    public void register(final CompanyModel company) {
        final var encodedPassword = encodePassword(company.getPassword());
        company.setPassword(encodedPassword);

        getUserRepository().save(company);
        // TODO: generate a token
        // TODO: send registration email
    }

    private String encodePassword(final String password) {
        // TODO: encode based on configured algorithm
        return password;
    }

}
