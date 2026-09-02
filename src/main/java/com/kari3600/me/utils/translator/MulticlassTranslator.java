package com.kari3600.me.utils.translator;

public interface MulticlassTranslator<T> {
    <I> I decode(T input, Class<I> clazz);
    Object decode(T input);
    T encode(Object input);
}
