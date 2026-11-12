package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

public interface KeyedMap<KeyType extends Key<?, ?>> extends ImmutableKeyedMap<KeyType> {
    <V> V put(Key<V, ? extends KeyType> key, V value);
}
