package com.kari3600.me.utils.throwing;

public interface ThrowingFunction<A,B,E extends Throwable> {
    B apply(A a) throws E;
}
