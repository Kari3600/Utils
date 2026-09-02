package com.kari3600.me.utils.collections;

import java.util.Iterator;

public class WrappedEnumerator<E> implements Enumerator<E> {
    private int position = 0;
    private final Iterator<E> iterator;

    public WrappedEnumerator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public int position() {
        return position;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        position++;
        return iterator.next();
    }
}
