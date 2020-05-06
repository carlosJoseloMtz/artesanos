package com.nopaldev.artesanos.core.services;

import com.nopaldev.artesanos.core.services.dtos.UserRegistrationDTO;

public interface CustomerRegistrationService {

    void register(final UserRegistrationDTO user);
}
