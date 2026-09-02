package com.kari3600.me.utils.reactive.variable;

public class SimpleVariable<T> extends ObservableValueBase<T> implements Variable<T> {
    public SimpleVariable(T value) {
        this.value = value;
    }

    @Override
    public void setValue(T value) {
        _setValue(value);
    }
}
