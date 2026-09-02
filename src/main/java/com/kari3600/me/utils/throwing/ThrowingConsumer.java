package com.kari3600.me.utils.throwing;

public interface ThrowingConsumer<A,E extends Throwable> {
    void accept(A a) throws E;

    default ThrowingFunction<A, Void, E> toFunction() {
        return a -> {
            accept(a);
            return null;
        };
    }
}
