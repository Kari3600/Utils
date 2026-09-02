package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

class ImmutableKeyedMapImpl implements ImmutableKeyedMap {
    protected final Map<Key<?>, Object> map;

    protected ImmutableKeyedMapImpl(Map<Key<?>, Object> map) {
        this.map = map;
    }

    @Override
    public <V> V get(Key<V> key) {
        return (V) map.get(key);
    }

    @Override
    public Set<Entry<?>> entrySet() {
        return map.entrySet().stream().map(entry ->
                (Entry<?>) new EntryImpl(entry.getKey(), entry.getValue())
        ).collect(Collectors.toSet());
    }

    @Override
    public void forEach(BiConsumer<Key<?>, Object> consumer) {
        entrySet().forEach(e -> consumer.accept(e.key(), e.value()));
    }

    private record EntryImpl<T>(Key<T> key, T value) implements Entry<T> {}
}
