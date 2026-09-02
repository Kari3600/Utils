package com.kari3600.me.utils.collections;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WrappedObjectMap<B> implements ObjectMap<B> {
    protected final Map<Class<? extends B>, B> map;

    public WrappedObjectMap(Map<Class<? extends B>, B> map) {
        this.map = map;
    }

    @Override
    public <T extends B> T get(Class<? extends T> clazz) {
        return clazz.cast(map.get(clazz));
    }

    @Override
    public <T extends B> T put(Class<? extends T> clazz, T value) {
        return clazz.cast(map.put(clazz, value));
    }

    @Override
    public <T extends B> T remove(Class<? extends T> clazz) {
        return clazz.cast(map.remove(clazz));
    }

    @Override
    public <T extends B> T computeIfAbsent(Class<? extends T> clazz, Function<? super Class<? extends B>, ? extends B> mappingFunction) {
        return (T) map.computeIfAbsent(clazz, mappingFunction);
    }

    @Override
    public Set<Class<? extends B>> keySet() {
        return map.keySet();
    }

    @Override
    public Set<? extends ObjectMap.Entry<? extends B>> entrySet() {
        return map.entrySet().stream()
                .map(e -> new Entry<>(e.getKey(), e.getValue()))
                .collect(Collectors.toSet());
    }

    @Override
    public Map<Class<? extends B>, B> asMap() {
        return map;
    }

    private static class Entry<T> implements ObjectMap.Entry<T> {
        private final Class<? extends T> clazz;
        private final T value;

        public Entry(Class<? extends T> clazz, T value) {
            this.clazz = clazz;
            this.value = value;
        }


        @Override
        public Class<? extends T> getKey() {
            return clazz;
        }

        @Override
        public T getValue() {
            return value;
        }
    }
}
