package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.SequencedMap;

public class WrappedSequencedKeyedMap<KeyType extends Key<?, ?>> extends WrappedKeyedMap<KeyType> implements SequencedKeyedMap<KeyType> {
    protected WrappedSequencedKeyedMap(SequencedMap<KeyType, Object> map) {
        super(map);
    }
}
