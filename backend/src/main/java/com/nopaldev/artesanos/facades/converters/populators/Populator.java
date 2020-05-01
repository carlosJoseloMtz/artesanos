package com.nopaldev.artesanos.facades.converters.populators;

public interface Populator<Source, Target> {

    void populate(final Source source, final Target target);
}
