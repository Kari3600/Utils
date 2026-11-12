package com.kari3600.me.utils.iteration;

import jdk.jfr.Experimental;

@Experimental
public class CyclicCounterIter<T> extends CyclicIter<T> {
    private final Iter<T> parent;

    public CyclicCounterIter(Iter<T> parent, Iterable<T> iterable) {
        super(iterable);
        this.parent = parent;
    }

    @Override
    public boolean next() {
        boolean res = iter.next();
        if (!res) {
            res = parent.next();
            iter = new WrappedIter<>(iterable.iterator());
            iter.next();
        }
        return res;
    }
}
