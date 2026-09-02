package com.kari3600.me.utils.collections;

public record ImmutablePairImpl<A, B>(A left, B right) implements ImmutablePair<A, B> {
}
