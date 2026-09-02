package com.kari3600.me.utils.object;

public interface Variable<T> extends Value<T> {
    void setValue(T value);
}
