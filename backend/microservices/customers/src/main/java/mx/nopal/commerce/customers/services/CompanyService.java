package mx.nopal.commerce.customers.services;

import mx.nopal.commerce.customers.model.CompanyModel;

public interface CompanyService extends UserService<CompanyModel> {
    void register(final CompanyModel company);
}
