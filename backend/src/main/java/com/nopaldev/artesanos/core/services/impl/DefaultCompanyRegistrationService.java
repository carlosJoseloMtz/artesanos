package com.nopaldev.artesanos.core.services.impl;

import com.nopaldev.artesanos.core.models.users.CraftsmanModel;
import com.nopaldev.artesanos.core.respositories.CraftsmanRepository;
import com.nopaldev.artesanos.core.services.CompanyRegistrationService;
import com.nopaldev.artesanos.core.services.dtos.CompanyRegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;


@Service("companyRegistrationService")
public class DefaultCompanyRegistrationService implements CompanyRegistrationService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCompanyRegistrationService.class);

    private final CraftsmanRepository craftsmanRepository;

    @Autowired
    public DefaultCompanyRegistrationService(final CraftsmanRepository craftsmanRepository) {
        this.craftsmanRepository = craftsmanRepository;
    }


    /**
     * @see CompanyRegistrationService#register(CompanyRegistrationDTO).
     */
    @Override
    public void register(final CompanyRegistrationDTO user) {
        Assert.notNull(user, "User can not be null");
        LOG.trace("Registering new company with name [{}]", user.getCompanyName());
        final var newUser = mapModel(user);
        getCraftsmanRepository().save(newUser);
        LOG.trace("Customer [{}] registered successfully", user.getCompanyName());
        // TODO: send registration email
    }

    protected CraftsmanModel mapModel(final CompanyRegistrationDTO dto) {
        final var model = new CraftsmanModel();
        model.setName(dto.getName());
        model.setCompanyName(dto.getCompanyName());
        model.setUsername(dto.getEmail());
        // TODO: hash the password
        model.setPassword(dto.getPassword());
        // enabled by default but requires validating the token
        model.setEnabled(true);
        // TODO: implement the token strategy
        model.setValidationToken(UUID.randomUUID().toString());
        return model;
    }

    public CraftsmanRepository getCraftsmanRepository() {
        return craftsmanRepository;
    }
}
