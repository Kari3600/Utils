package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.LinkedHashMap;
import java.util.SequencedMap;

public interface ImmutableSequencedKeyedMap extends ImmutableKeyedMap {
    static Builder builder() {
        return new Builder(new LinkedHashMap<>());
    }

    class Builder extends ImmutableKeyedMap.Builder {
        private Builder(SequencedMap<Key<?>, Object> map) {
            super(map);
        }

        @Override
        public ImmutableSequencedKeyedMap build() {
            return new ImmutableSequencedKeyedMapImpl((SequencedMap<Key<?>, Object>) map);
        }
    }
}
