package com.nopaldev.artesanos.facades;

import com.nopaldev.artesanos.facades.dtos.RegisterDTO;

import javax.validation.Valid;

public interface CustomerFacade {
    void register(@Valid final RegisterDTO registerInfo);
}
