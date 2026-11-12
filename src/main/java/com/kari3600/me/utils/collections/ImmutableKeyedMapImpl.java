package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

class ImmutableKeyedMapImpl<KeyType extends Key<?, ?>> implements ImmutableKeyedMap<KeyType> {
    protected final Map<KeyType, Object> map;

    protected ImmutableKeyedMapImpl(Map<KeyType, Object> map) {
        this.map = map;
    }

    @Override
    public <V> V get(Key<V, ? extends KeyType> key) {
        return (V) map.get(key);
    }

    @Override
    public Set<Entry<KeyType, ?>> entrySet() {
        return map.entrySet().stream().map(entry ->
                (Entry<KeyType, ?>) new EntryImpl(entry.getKey(), entry.getValue())
        ).collect(Collectors.toSet());
    }

    @Override
    public void forEach(BiConsumer<KeyType, Object> consumer) {
        entrySet().forEach(e -> consumer.accept(e.key(), e.value()));
    }

    private record EntryImpl<KeyType extends Key<V, ?>, V>(KeyType key, V value) implements Entry<KeyType, V> {}
}
