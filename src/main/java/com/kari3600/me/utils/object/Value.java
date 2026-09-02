package com.kari3600.me.utils.object;

public interface Value<T> {
    T getValue();

    static <T> Value<T> of(T value) {
        return new FinalValue<>(value);
    }

    class FinalValue<T> implements Value<T> {
        private final T value;

        @Override
        public T getValue() {
            return value;
        }

        public FinalValue(T value) {
            this.value = value;
        }
    }
}
