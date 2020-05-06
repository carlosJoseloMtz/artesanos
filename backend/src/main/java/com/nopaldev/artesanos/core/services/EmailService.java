package com.nopaldev.artesanos.core.services;

import com.nopaldev.artesanos.core.services.dtos.BaseEmailContext;


public interface EmailService {

    void send(final String code, final BaseEmailContext context);

}
