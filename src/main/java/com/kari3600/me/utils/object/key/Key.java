package com.kari3600.me.utils.object.key;

public interface Key<T, K extends Key<? super T,K>> {
    K self();
}
