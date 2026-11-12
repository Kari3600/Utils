package com.kari3600.me.utils.iteration;

import java.util.*;

public class CombinationsIter<T> implements Iter<List<T>> {

    private final LinkedList<Iter<T>> iterators = new LinkedList<>();

    public CombinationsIter(List<? extends Iterable<T>> iterables) {
        Iterator<? extends Iterable<T>> it = iterables.iterator();
        Iter<T> iter = new WrappedIter<>(it.next().iterator());
        iterators.add(iter);
        if (it.hasNext()) iter.next();
        while (it.hasNext()) {
            iter = new CyclicCounterIter<>(iter, it.next());
            iterators.add(iter);
            if (it.hasNext()) iter.next();
        }
    }

    @Override
    public boolean next() {
        return iterators.peekLast().next();
    }

    @Override
    public List<T> get() {
        return iterators.stream()
                .map(Iter::get)
                .toList();
    }
}
