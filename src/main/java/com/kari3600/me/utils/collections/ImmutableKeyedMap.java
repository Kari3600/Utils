package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public interface ImmutableKeyedMap {
    <V> V get(Key<V> key);

    Set<Entry<?>> entrySet();
    void forEach(BiConsumer<Key<?>,Object> consumer);

    static <K1> ImmutableKeyedMap of(Key<K1> key, K1 value) {
        return new ImmutableKeyedMapImpl(Map.of(key, value));
    }

    static <K1,K2> ImmutableKeyedMap of(Key<K1> key1, K1 value1, Key<K2> key2, K2 value2) {
        return new ImmutableKeyedMapImpl(Map.of(key1, value1, key2, value2));
    }

    static <K1,K2,K3> ImmutableKeyedMap of(Key<K1> key1, K1 value1, Key<K2> key2, K2 value2, Key<K3> key3, K3 value3) {
        return new ImmutableKeyedMapImpl(Map.of(key1, value1, key2, value2, key3, value3));
    }

    static Builder builder() {
        return new Builder(new HashMap<>());
    }

    class Builder {
        protected final Map<Key<?>, Object> map;

        public Builder(Map<Key<?>, Object> map) {
            this.map = map;
        }

        public <T> Builder put(Key<T> key, T value) {
            map.put(key, value);
            return this;
        }

        public Builder putUnchecked(Key<?> key, Object value) {
            map.put(key, value);
            return this;
        }

        public Builder putAll(Map<Key<?>, Object> map) {
            this.map.putAll(map);
            return this;
        }

        public Builder putAll(ImmutableKeyedMap map) {
            map.forEach(this::putUnchecked);
            return this;
        }

        public ImmutableKeyedMap build() {
            return new ImmutableKeyedMapImpl(map);
        }
    }

    interface Entry<V> {
        Key<V> key();
        V value();
    }
}
