package com.kari3600.me.utils.serialization;

import com.kari3600.me.utils.translator.Translator;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface ObjectReader {
    String readString(String key);

    int readInteger(String key);

    long readLong(String key);

    double readDouble(String key);

    boolean readBoolean(String key);

    <T> T read(String key, Class<T> clazz);
    <T> List<T> readList(String key, Class<T> clazz);
    <T> T[] readArray(String key, Class<T> clazz);
    <T> Map<String, T> readMap(String key, Class<T> clazz);
    <T> Map<String, T> readMap(String key, Function<String, Class<? extends T>> function);
    <K, V> Map<K, V> readMap(String key, Class<V> clazz, Translator<K, String> keyTranslator);
    <K, V> Map<K, V> readMap(String key, Function<K, Class<? extends V>> function, Translator<K, String> keyTranslator);
}
