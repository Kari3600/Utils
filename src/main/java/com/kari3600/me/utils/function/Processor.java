package com.kari3600.me.utils.function;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Processor<I,O> {
    boolean applicable(I input);
    O process(I input);

    static <I,O> Processor<I,O> create(Predicate<I> predicate, Function<I, O> function) {
        return new Processor<>() {
            @Override
            public boolean applicable(I input) {
                return predicate.test(input);
            }

            @Override
            public O process(I input) {
                return function.apply(input);
            }
        };
    }
}
