package com.kari3600.me.utils.reactive.variable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class ObservableValueBase<T> extends ObservableBase implements ObservableValue<T> {
    private final Set<ChangeListener<? super T>> listeners = new HashSet<>();
    protected T value;

    @Override
    public void addListener(ChangeListener<? super T> listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super T> listener) {
        listeners.remove(listener);
    }

    @Override
    public T getValue() {
        return value;
    }

    protected void _setValue(T value) {
        if (Objects.equals(this.value, value)) return;
        T oldValue = this.value;
        this.value = value;
        for (ChangeListener<? super T> listener : listeners) {
            listener.onValueChange(this, oldValue, value);
        }
    }
}
