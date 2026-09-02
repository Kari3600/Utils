package com.kari3600.me.utils.throwing;

public interface ThrowingRunnable<E extends Throwable> {
    void run() throws E;
}
