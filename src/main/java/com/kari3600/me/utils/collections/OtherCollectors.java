package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.object.key.Key;

import java.util.function.Function;
import java.util.stream.Collector;

public class OtherCollectors {
    public static <T> Collector<T, ?, ImmutableKeyedMap> toKeyedMap(
            Function<? super T, ? extends Key<?>> keyFunction,
            Function<? super T, ?> valueFunction
    ) {
        return Collector.of(
                ImmutableKeyedMap::builder,
                (builder, t) -> builder.putUnchecked(keyFunction.apply(t), valueFunction.apply(t)),
                (builder, builder2) -> builder.putAll(builder2.build()),
                ImmutableKeyedMap.Builder::build
        );
    }
}
