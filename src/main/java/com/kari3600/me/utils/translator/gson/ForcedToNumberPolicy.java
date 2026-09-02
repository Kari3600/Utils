package com.kari3600.me.utils.translator.gson;

import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

public class ForcedToNumberPolicy implements ToNumberStrategy {
    @Override
    public Number readNumber(JsonReader in) throws IOException {
        Number n = ToNumberPolicy.LONG_OR_DOUBLE.readNumber(in);
        if (n instanceof Long) {
            if (n.longValue() > Integer.MIN_VALUE && n.longValue() < Integer.MAX_VALUE) {
                return n.intValue();
            }
        }
        return n;
    }
}
