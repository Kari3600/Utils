package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

public interface SequencedKeyedMap<KeyType extends Key<?, ?>> extends ImmutableSequencedKeyedMap<KeyType>, KeyedMap<KeyType> {
}
