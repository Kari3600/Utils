package com.kari3600.me.utils.throwing;

import java.util.Iterator;
import java.util.function.Function;

public interface ThrowingIterator<T, E extends Throwable> {
    boolean hasNext() throws E;
    T next() throws E;

    default Iterator<T> asIterator() {
        return asIterator(RuntimeException::new);
    }

    default <U extends RuntimeException> Iterator<T> asIterator(Function<Throwable, U> uncheckedFactory) {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                try {
                    return ThrowingIterator.this.hasNext();
                } catch (Throwable e) {
                    throw uncheckedFactory.apply(e);
                }
            }

            @Override
            public T next() {
                try {
                    return ThrowingIterator.this.next();
                } catch (Throwable e) {
                    throw uncheckedFactory.apply(e);
                }
            }
        };
    }
}
