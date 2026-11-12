package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.function.Function;
import java.util.stream.Collector;

public class CollectorsUtil {
    public static <T, KeyType extends Key<?, ?>> Collector<T, ?, ImmutableKeyedMap<KeyType>> toKeyedMap(
            Function<? super T, ? extends KeyType> keyFunction,
            Function<? super T, ?> valueFunction
    ) {
        return Collector.of(
                ImmutableKeyedMap::builder,
                (ImmutableKeyedMap.Builder<KeyType> builder, T t) -> builder.putUnchecked(keyFunction.apply(t), valueFunction.apply(t)),
                (builder, builder2) -> builder.putAll(builder2.build()),
                ImmutableKeyedMap.Builder::build
        );
    }
}
