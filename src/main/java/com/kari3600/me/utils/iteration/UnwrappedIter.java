package com.kari3600.me.utils.iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnwrappedIter<T> implements Iterator<T> {
    private final Iter<T> iter;
    private Boolean hasNext = null;

    public UnwrappedIter(Iter<T> iter) {
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        if (hasNext == null) {
            hasNext = iter.next();
        }
        return hasNext;
    }

    @Override
    public T next() {
        if (hasNext == null) {
            hasNext = iter.next();
        }
        if (!hasNext) {
            throw new NoSuchElementException();
        }
        hasNext = null;
        return iter.get();
    }
}
