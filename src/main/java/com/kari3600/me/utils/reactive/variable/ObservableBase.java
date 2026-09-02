package com.kari3600.me.utils.reactive.variable;

import java.util.HashSet;
import java.util.Set;

public abstract class ObservableBase implements Observable {
    private final Set<InvalidationListener> invalidationListeners = new HashSet<>();

    @Override
    public void addListener(InvalidationListener listener) {
        invalidationListeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        invalidationListeners.remove(listener);
    }

    protected void fireInvalidation() {
        for (InvalidationListener listener : invalidationListeners) {
            listener.invalidated(this);
        }
    }
}
