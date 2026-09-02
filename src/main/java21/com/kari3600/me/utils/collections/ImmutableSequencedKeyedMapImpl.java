package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.SequencedMap;

public class ImmutableSequencedKeyedMapImpl extends ImmutableKeyedMapImpl implements ImmutableSequencedKeyedMap {
    protected ImmutableSequencedKeyedMapImpl(SequencedMap<Key<?>, Object> map) {
        super(map);
    }


}
