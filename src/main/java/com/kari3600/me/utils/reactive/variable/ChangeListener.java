package com.kari3600.me.utils.reactive.variable;

public interface ChangeListener<T> {
    void onValueChange(ObservableValue<? extends T> observableValue, T from, T to);
}
