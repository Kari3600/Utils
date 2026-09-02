package com.kari3600.me.utils.collections;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WrappedOneToOneMap<A,B> implements OneToOneMap<A,B> {
    private final Map<A,B> leftMap;
    private final Map<B,A> rightMap;

    public WrappedOneToOneMap(Map<A, B> leftMap, Map<B, A> rightMap) {
        this.leftMap = leftMap;
        this.rightMap = rightMap;
    }

    @Override
    public A getLeft(B right) {
        return rightMap.get(right);
    }

    @Override
    public B getRight(A left) {
        return leftMap.get(left);
    }

    @Override
    public A removeLeft(B right) {
        A removed = rightMap.remove(right);
        if (removed != null) {
            leftMap.remove(removed);
        }
        return removed;
    }

    @Override
    public B removeRight(A left) {
        B removed = leftMap.remove(left);
        if (removed != null) {
            rightMap.remove(removed);
        }
        return removed;
    }

    @Override
    public void put(A left, B right) {
        leftMap.put(left, right);
        rightMap.put(right, left);
    }

    @Override
    public Set<OneToOneMap.Entry<A, B>> entrySet() {
        return leftMap.entrySet().stream()
                .map(e -> new Entry<>(e.getKey(), e.getValue()))
                .collect(Collectors.toSet());
    }

    private record Entry<A, B>(A left, B right) implements OneToOneMap.Entry<A, B> {
    }
}
