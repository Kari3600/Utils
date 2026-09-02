package com.kari3600.me.utils.translator;

public interface Translator<I,O> {
    O encode(I input);
    I decode(O output);
}
