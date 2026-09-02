package com.kari3600.me.utils.collections;

import java.util.Set;

public interface OneToOneMap<A,B> {
    A getLeft(B right);
    B getRight(A left);

    A removeLeft(B right);
    B removeRight(A left);

    void put(A left, B right);

    Set<Entry<A,B>> entrySet();

    interface Entry<A,B> {
        A left();
        B right();
    }
}
