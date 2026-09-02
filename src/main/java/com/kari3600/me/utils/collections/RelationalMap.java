package com.kari3600.me.utils.collections;

import java.util.Map;

public interface RelationalMap<K,V> extends ImmutableRelationalMap<K,V> {
    V put(K first, K second, V value);
    V remove(K first, K second);
    Map<K, V> put(K first, Map<K, V> values);
    Map<K, V> remove(K first);
}
