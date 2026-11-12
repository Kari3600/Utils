package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.SequencedMap;

public class ImmutableSequencedKeyedMapImpl<KeyType extends Key<?, ?>> extends ImmutableKeyedMapImpl<KeyType> implements ImmutableSequencedKeyedMap<KeyType> {
    protected ImmutableSequencedKeyedMapImpl(SequencedMap<KeyType, Object> map) {
        super(map);
    }


}
