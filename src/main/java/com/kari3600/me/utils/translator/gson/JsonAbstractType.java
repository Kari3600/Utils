package com.kari3600.me.utils.translator.gson;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAbstractType {
    JsonAbstractSubtype[] subtypes();
}
