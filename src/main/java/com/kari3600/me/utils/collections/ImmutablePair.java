package com.kari3600.me.utils.collections;

public interface ImmutablePair<A,B> {
    A getLeft();
    B getRight();

    static <A,B> ImmutablePair<A,B> of(A left, B right) {
        return new ImmutablePairImpl<>(left, right);
    }
}
