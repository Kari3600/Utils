package com.kari3600.me.utils.collections;

import java.util.Map;
import java.util.function.Function;

public abstract class KeyJoinedDefaultingRelationalMap<K,V> implements ImmutableRelationalMap<K,V> {
    private final Map<K, Map<K, V>> map;
    private final Function<K, Map<K, V>> mapProvider;

    protected KeyJoinedDefaultingRelationalMap(Map<K, Map<K, V>> map, Function<K, Map<K, V>> mapProvider) {
        this.map = map;
        this.mapProvider = mapProvider;
    }

    @Override
    public V get(K first, K second) {
        Map<K, V> map = this.map.get(first);
        if (map == null) return null;
        return map.get(second);
    }

    @Override
    public Map<K, V> get(K first) {
        return map.get(first);
    }

    public void add(K key) {
        Map<K, V> subMap = mapProvider.apply(key);
        map.put(key, subMap);
        map.forEach((k,v) -> {
            v.put(key, getDefault(k, key));
            subMap.put(k, getDefault(key, k));
        });
    }

    public void remove(K key) {
        Map<K, V> subMap = map.remove(key);
        for (Map<K, V> subMaps : map.values()) {
            subMaps.remove(key);
        }
    }

    protected abstract V getDefault(K first, K second);
}
