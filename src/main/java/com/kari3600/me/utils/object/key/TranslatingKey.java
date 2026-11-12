package com.kari3600.me.utils.object.key;

import com.kari3600.me.utils.translator.Translator;

public interface TranslatingKey<I,O,K extends TranslatingKey<I,O,K>> extends Key<I,K> {
    Translator<I,O> getTranslator();
}
