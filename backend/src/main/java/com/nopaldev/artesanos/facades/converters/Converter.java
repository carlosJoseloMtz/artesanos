package com.nopaldev.artesanos.facades.converters;

import java.util.Collection;

public interface Converter<Source, Target> {
    Target convert(final Source source);

    Collection<Target> convertAll(final Collection<Source> sources);
}
