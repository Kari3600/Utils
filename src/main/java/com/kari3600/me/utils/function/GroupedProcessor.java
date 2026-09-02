package com.kari3600.me.utils.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class GroupedProcessor<I,O> {
    private final List<Processor<I,O>> processorList = new ArrayList<>();

    public void add(Processor<I,O> processor) {
        processorList.add(processor);
    }

    public void add(Predicate<I> predicate, Function<I,O> function) {
        processorList.add(Processor.create(predicate, function));
    }

    public O process(I input) {
        for (Processor<I,O> processor : processorList) {
            if (processor.applicable(input)) {
                return processor.process(input);
            }
        }
        return null;
    }
}
