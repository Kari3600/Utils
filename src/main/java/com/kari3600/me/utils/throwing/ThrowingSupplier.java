package com.kari3600.me.utils.throwing;

public interface ThrowingSupplier<T, E extends Throwable> {
    T get() throws E;
}
