package com.kari3600.me.utils.collections;

public interface Pair<A,B> extends ImmutablePair<A,B> {
    void setLeft(A left);
    void setRight(B right);
}
