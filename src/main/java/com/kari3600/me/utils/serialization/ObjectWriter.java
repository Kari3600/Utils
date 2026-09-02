package com.kari3600.me.utils.serialization;

import com.kari3600.me.utils.translator.Translator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface ObjectWriter {
    void writeString(String key, String value);

    void writeInteger(String key, int value);

    void writeLong(String key, long value);

    void writeDouble(String key, double value);

    void writeBoolean(String key, boolean value);

    <T> void write(String key, T value, Class<T> clazz);
    <T> void writeList(String key, List<T> value, Class<T> clazz);
    <T> void writeArray(String key, T[] value, Class<T> clazz);
    <T> void writeMap(String key, Map<String, T> value, Class<T> clazz);
    <T> void writeMap(String key, Map<String, T> value, Function<String, Class<? extends T>> function);
    <K, V> void writeMap(String key, Map<K, V> value, Class<V> clazz, Translator<K, String> keyTranslator);
    <K, V> void writeMap(String key, Map<K, V> value, Function<K, Class<? extends V>> function, Translator<K, String> keyTranslator);
}
