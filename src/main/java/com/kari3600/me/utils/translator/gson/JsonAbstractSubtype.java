package com.kari3600.me.utils.translator.gson;

public @interface JsonAbstractSubtype {
    Class<?> subtype();
    String name();
}
