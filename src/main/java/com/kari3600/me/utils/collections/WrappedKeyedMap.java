package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.Map;

public class WrappedKeyedMap extends ImmutableKeyedMapImpl implements KeyedMap {
    public WrappedKeyedMap(Map<Key<?>, Object> map) {
        super(map);
    }

    @Override
    public <V> V put(Key<V> key, V value) {
        return (V) map.put(key, value);
    }
}
