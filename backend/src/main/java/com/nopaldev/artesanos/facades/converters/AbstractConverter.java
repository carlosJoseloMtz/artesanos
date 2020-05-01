package com.nopaldev.artesanos.facades.converters;


import com.nopaldev.artesanos.facades.converters.populators.Populator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbstractConverter<Source, Target> implements Converter<Source, Target> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractConverter.class);

    private Class<Target> targetClass;
    private List<Populator<Source, Target>> populators;

    public AbstractConverter(final Class<Target> targetClass,
                             final List<Populator<Source, Target>> populators) {
        this.targetClass = targetClass;
        this.populators = populators;
    }

    @Override
    public Collection<Target> convertAll(final Collection<Source> sources) {

        if (sources == null || sources.isEmpty()) {
            return Collections.emptyList();
        }

        return sources.parallelStream()
                .map(this::convert)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public Target convert(final Source source) {
        final var target = createInstance();

        if (target == null || getPopulators() == null || getPopulators().isEmpty()) {
            return null;
        }

        getPopulators().parallelStream()
                .forEach(pop -> pop.populate(source, target));

        return target;
    }

    private Target createInstance() {
        try {
            return getTargetClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            LOG.error("Could not instantiate target class [{}]", getTargetClass().getSimpleName(), ex);
        }

        return null;
    }

    public Class<Target> getTargetClass() {
        return targetClass;
    }

    public List<Populator<Source, Target>> getPopulators() {
        return populators;
    }
}
