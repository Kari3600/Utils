package com.kari3600.me.utils.collections;

public interface Pair<A,B> extends ImmutablePair<A,B> {
    void setLeft(A left);
    void setRight(B right);
    static <A,B> Pair<A,B> of(A left, B right) {
        return new PairImpl<>(left,right);
    }
}
