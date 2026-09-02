package com.kari3600.me.utils.reactive.variable;

import java.util.List;

public interface Binding<T> extends ObservableValue<T> {
    boolean isValid();

    void invalidate();

    List<?> getDependencies();

    void dispose();
}
