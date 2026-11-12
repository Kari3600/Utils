package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.Map;

public class WrappedKeyedMap<KeyType extends Key<?, ?>> extends ImmutableKeyedMapImpl<KeyType> implements KeyedMap<KeyType> {
    public WrappedKeyedMap(Map<KeyType, Object> map) {
        super(map);
    }

    @Override
    public <V> V put(Key<V, ? extends KeyType> key, V value) {
        return (V) map.put(key.self(), value);
    }
}
