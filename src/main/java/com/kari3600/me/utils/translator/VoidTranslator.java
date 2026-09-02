package com.kari3600.me.utils.translator;

public class VoidTranslator implements Translator<Void, String> {
    @Override
    public String encode(Void input) {
        return "null";
    }

    @Override
    public Void decode(String output) {
        return null;
    }
}
