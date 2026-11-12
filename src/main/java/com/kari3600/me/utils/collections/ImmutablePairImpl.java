package com.kari3600.me.utils.collections;

public record ImmutablePairImpl<A, B>(A getLeft, B getRight) implements ImmutablePair<A, B> {
    @Override
    public String toString() {
        return "(" + getLeft() + ", " + getRight() + ")";
    }
}
