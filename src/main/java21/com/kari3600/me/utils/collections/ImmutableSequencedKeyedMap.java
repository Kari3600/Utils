package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.LinkedHashMap;
import java.util.SequencedMap;

public interface ImmutableSequencedKeyedMap<KeyType extends Key<?, ?>> extends ImmutableKeyedMap<KeyType> {
    static <KeyType extends Key<?, ?>> Builder<KeyType> builder() {
        return new Builder<>(new LinkedHashMap<>());
    }

    class Builder<KeyType extends Key<?, ?>> extends ImmutableKeyedMap.Builder<KeyType> {
        private Builder(SequencedMap<KeyType, Object> map) {
            super(map);
        }

        @Override
        public ImmutableSequencedKeyedMap<KeyType> build() {
            return new ImmutableSequencedKeyedMapImpl<>((SequencedMap<KeyType, Object>) map);
        }
    }
}
