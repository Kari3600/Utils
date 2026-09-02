package com.kari3600.me.utils.collections;

import java.util.Map;

public interface ImmutableRelationalMap<K,V> {
    V get(K first, K second);
    Map<K, V> get(K first);
}
