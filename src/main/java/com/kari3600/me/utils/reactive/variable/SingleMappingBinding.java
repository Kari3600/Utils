package com.kari3600.me.utils.reactive.variable;

import java.util.List;
import java.util.function.Function;

public class SingleMappingBinding<T,V> extends BindingBase<T> {
    private final ObservableValue<V> observableValue;
    private final Function<V, T> mapper;
    private final InvalidationListener listener;

    public SingleMappingBinding(ObservableValue<V> observableValue, Function<V, T> mapper) {
        this.observableValue = observableValue;
        this.mapper = mapper;
        this.listener = observable -> invalidate();
        observableValue.addListener(listener);
    }

    @Override
    protected T findValue() {
        return mapper.apply(observableValue.getValue());
    }

    @Override
    public List<?> getDependencies() {
        return List.of(observableValue);
    }

    @Override
    public void dispose() {
        observableValue.removeListener(listener);
    }
}
