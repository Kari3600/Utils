package com.kari3600.me.utils.collections;

public class CollectionUtil {
    public static <T> Enumerator<T> enumerate(Iterable<T> collection) {
        return new WrappedEnumerator<>(collection.iterator());
    }
}
