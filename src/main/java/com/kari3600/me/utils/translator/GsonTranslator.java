package com.kari3600.me.utils.translator;

import com.google.gson.Gson;

public class GsonTranslator<T> implements Translator<T,String> {

    private final Gson gson;
    private final Class<T> clazz;

    @Override
    public String encode(T input) {
        return gson.toJson(input);
    }

    @Override
    public T decode(String output) {
        return gson.fromJson(output, clazz);
    }

    public GsonTranslator(Class<T> clazz) {
        this(clazz, new Gson());
    }
    public GsonTranslator(Class<T> clazz, Gson gson) {
        this.clazz = clazz;
        this.gson = gson;
    }
}
