package com.kari3600.me.utils.reactive.variable;

public interface Variable<T> extends ObservableValue<T> {
    void setValue(T value);
}
