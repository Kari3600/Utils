package com.kari3600.me.utils.translator;

public class RepeaterTranslator<T> implements Translator<T,T> {
    @Override
    public T encode(T input) {
        return input;
    }

    @Override
    public T decode(T output) {
        return output;
    }
}
