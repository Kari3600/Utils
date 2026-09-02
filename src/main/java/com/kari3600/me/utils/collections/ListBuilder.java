package com.kari3600.me.utils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class ListBuilder<T> {
    private final List<T> list;

    public ListBuilder(List<T> list) {
        this.list = list;
    }

    public ListBuilder() {
        this.list = new ArrayList<>();
    }

    public ListBuilder<T> add(T item) {
        this.list.add(item);
        return this;
    }

    public ListBuilder<T> addAll(Collection<T> items) {
        this.list.addAll(items);
        return this;
    }

    public ListBuilder<T> addAll(T... items) {
        return this.addAll(Arrays.asList(items));
    }

    public ListBuilder<T> addIf(boolean condition, Supplier<T> supplier) {
        if (condition) {
            this.add(supplier.get());
        }
        return this;
    }

    public List<T> build() {
        return this.list;
    }
}
