package com.kari3600.me.utils.object.key;

import com.kari3600.me.utils.translator.Translator;

public interface TranslatingKey<I,O> extends Key<I> {
    Translator<I,O> getTranslator();
}
