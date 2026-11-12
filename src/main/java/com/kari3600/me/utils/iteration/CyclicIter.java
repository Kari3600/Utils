package com.kari3600.me.utils.iteration;

public class CyclicIter<T> implements Iter<T> {
    protected final Iterable<T> iterable;
    protected Iter<T> iter;

    public CyclicIter(Iterable<T> iterable) {
        this.iterable = iterable;
        this.iter = new WrappedIter<>(iterable.iterator());
    }

    @Override
    public boolean next() {
        boolean res = iter.next();
        if (!res) {
            iter = new WrappedIter<>(iterable.iterator());
            iter.next();
        }
        return true;
    }

    @Override
    public T get() {
        return iter.get();
    }
}
