package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public interface ImmutableKeyedMap<K extends Key<?, ?>> {
    <V> V get(Key<V, ? extends K> key);

    Set<Entry<K, ?>> entrySet();
    void forEach(BiConsumer<K,Object> consumer);

    static <KeyType extends Key<?, ?>, K1> ImmutableKeyedMap<KeyType> of(Key<K1, ? extends KeyType> key, K1 value) {
        return new ImmutableKeyedMapImpl<>(Map.of(key.self(), value));
    }

    static <KeyType extends Key<?, ?>, K1,K2> ImmutableKeyedMap<KeyType> of(Key<K1, ? extends KeyType> key1, K1 value1, Key<K2, ? extends KeyType> key2, K2 value2) {
        return new ImmutableKeyedMapImpl<>(Map.of(key1.self(), value1, key2.self(), value2));
    }

    static <KeyType extends Key<?, ?>, K1,K2,K3> ImmutableKeyedMap<KeyType> of(Key<K1, ? extends KeyType> key1, K1 value1, Key<K2, ? extends KeyType> key2, K2 value2, Key<K3, ? extends KeyType> key3, K3 value3) {
        return new ImmutableKeyedMapImpl<>(Map.of(key1.self(), value1, key2.self(), value2, key3.self(), value3));
    }

    static <KeyType extends Key<?,?>> Builder<KeyType> builder() {
        return new Builder<>(new HashMap<>());
    }

    class Builder<KeyType extends Key<?, ?>> {
        protected final Map<KeyType, Object> map;

        public Builder(Map<KeyType, Object> map) {
            this.map = map;
        }

        public <T> Builder<KeyType> put(Key<T, ? extends KeyType> key, T value) {
            map.put(key.self(), value);
            return this;
        }

        public Builder<KeyType> putUnchecked(KeyType key, Object value) {
            map.put(key, value);
            return this;
        }

        public Builder<KeyType> putAll(Map<KeyType, Object> map) {
            this.map.putAll(map);
            return this;
        }

        public Builder<KeyType> putAll(ImmutableKeyedMap<KeyType> map) {
            map.forEach(this::putUnchecked);
            return this;
        }

        public ImmutableKeyedMap<KeyType> build() {
            return new ImmutableKeyedMapImpl<>(map);
        }
    }

    interface Entry<KeyType extends Key<V, ?>, V> {
        KeyType key();
        V value();
    }
}
