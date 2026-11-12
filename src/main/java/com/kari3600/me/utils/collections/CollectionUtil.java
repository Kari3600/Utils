package com.kari3600.me.utils.collections;

import com.kari3600.me.utils.iteration.CombinationsIter;
import com.kari3600.me.utils.iteration.Iter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class CollectionUtil {
    public static <T> Enumerator<T> enumerate(Iterable<T> collection) {
        return new WrappedEnumerator<>(collection.iterator());
    }

    public static <T> Iter<List<T>> combinations(List<? extends Collection<T>> list) {
        return new CombinationsIter<>(list);
    }

    public static <D,T> Iter<List<T>> combinations(List<D> list, Function<D, Collection<T>> valueMapper) {
        return new CombinationsIter<>(list.stream().map(valueMapper).toList());
    }
}
