package com.kari3600.me.utils.iteration;

import java.util.Iterator;

public class WrappedIter<T> implements Iter<T> {
    private final Iterator<T> iterator;
    private T next;

    public WrappedIter(Iterator<T> iterator) {
        this.iterator = iterator;
    }


    @Override
    public boolean next() {
        if (iterator.hasNext()) {
            next = iterator.next();
            return true;
        }
        return false;
    }

    @Override
    public T get() {
        return next;
    }
}
