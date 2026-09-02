package com.kari3600.me.utils.throwing;

import java.util.NoSuchElementException;

public abstract class ThrowingOptional<T> {
    public static <T> ThrowingOptional<T> of(T value) {
        return new Present<>(value);
    }

    public static <T> ThrowingOptional<T> ofNullable(T value) {
        if (value == null) {
            return empty();
        } else {
            return of(value);
        }
    }

    public static <T> ThrowingOptional<T> empty() {
        return (ThrowingOptional<T>) Absent.INSTANCE;
    }

    public abstract T get();

    public abstract <V,E extends Throwable> ThrowingOptional<V> map(ThrowingFunction<T, V, E> function) throws E;

    public abstract T orElse(T other);

    private static class Present<T> extends ThrowingOptional<T> {
        private final T value;

        Present(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }

        @Override
        public <V, E extends Throwable> ThrowingOptional<V> map(ThrowingFunction<T, V, E> function) throws E {
            return new Present<>(function.apply(value));
        }

        @Override
        public T orElse(T other) {
            return value;
        }
    }

    private static class Absent extends ThrowingOptional<Object> {
        private static final Absent INSTANCE = new Absent();

        @Override
        public Object get() {
            throw new NoSuchElementException("No value present");
        }

        @Override
        public <V, E extends Throwable> ThrowingOptional<V> map(ThrowingFunction<Object, V, E> function) throws E {
            return (ThrowingOptional<V>) this;
        }

        @Override
        public Object orElse(Object other) {
            return other;
        }
    }
}
