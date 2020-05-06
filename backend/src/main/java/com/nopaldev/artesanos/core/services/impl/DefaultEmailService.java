package com.nopaldev.artesanos.core.services.impl;

import com.nopaldev.artesanos.core.services.EmailService;
import com.nopaldev.artesanos.core.services.dtos.BaseEmailContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class DefaultEmailService implements EmailService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultEmailService.class);

    // TODO: make this asynchronous - probably looking at a future response will be good :thinking:, not sure, though
    @Override
    public void send(final String code, final BaseEmailContext context) {
        Assert.notNull(code, "Code can not be null");
        Assert.isTrue(!code.isEmpty(), "Code can not be empty");

        LOG.debug("Sending email with code [{}]", code);

        // TODO: find the email in a hash of emails by code, pass the parameters via the context
        //  then just trigger a strategy, hash can be hardcoded for now at least, later we'll register them into the service
    }
}
