package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.SequencedMap;

public class WrappedSequencedKeyedMap extends WrappedKeyedMap implements SequencedKeyedMap {
    protected WrappedSequencedKeyedMap(SequencedMap<Key<?>, Object> map) {
        super(map);
    }
}
