package com.kari3600.me.utils.collections;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;

public interface Enumerator<E> extends Iterator<E> {
    int position();
    default void forEachRemaining(BiConsumer<Integer, ? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(position(), next());
    }
}
