package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

public interface KeyedMap extends ImmutableKeyedMap {
    <V> V put(Key<V> key, V value);
}
