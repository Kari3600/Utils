package com.kari3600.me.utils.collections;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public interface ObjectMap<B> {
    <T extends B> T get(Class<? extends T> clazz);
    <T extends B> T put(Class<? extends T> clazz, T value);
    <T extends B> T remove(Class<? extends T> clazz);
    <T extends B> T computeIfAbsent(Class<? extends T> clazz, Function<? super Class<? extends B>, ? extends B> mappingFunction);
    Set<Class<? extends B>> keySet();
    Set<? extends Entry<? extends B>> entrySet();
    Map<Class<? extends B>,B> asMap();

    default void addAll(ObjectMap<B> map) {
        map.entrySet().forEach(e -> put(e.getKey(), e.getValue()));
    }

    interface Entry<T> {
        Class<? extends T> getKey();
        T getValue();
    }
}
