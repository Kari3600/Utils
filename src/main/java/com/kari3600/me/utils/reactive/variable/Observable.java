package com.kari3600.me.utils.reactive.variable;

public interface Observable {
    void addListener(InvalidationListener listener);
    void removeListener(InvalidationListener listener);
}
