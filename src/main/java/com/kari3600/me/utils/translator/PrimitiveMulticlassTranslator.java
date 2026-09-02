package com.kari3600.me.utils.translator;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrimitiveMulticlassTranslator implements MulticlassTranslator<String> {

    @Override
    public <I> I decode(String input, Class<I> clazz) {
        if (clazz == String.class) {
            return (I) input;
        } else if (clazz == Integer.class) {
            return (I) Integer.valueOf(input);
        } else if (clazz == Double.class) {
            return (I) Double.valueOf(input);
        } else if (clazz == Boolean.class) {
            return (I) Boolean.valueOf(input);
        } else if (clazz == Long.class) {
            return (I) Long.valueOf(input);
        } else if (clazz == Float.class) {
            return (I) Float.valueOf(input);
        } else if (clazz == Byte.class) {
            return (I) Byte.valueOf(input);
        } else if (clazz == Short.class) {
            return (I) Short.valueOf(input);
        } else if (clazz == InetAddress.class) {
            try {
                return (I) InetAddress.getByName(input);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported type: " + clazz);
        }
    }

    @Override
    public Object decode(String input) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String encode(Object input) {
        if (input instanceof InetAddress) {
            return input.toString().substring(1);
        } else {
            return input.toString();
        }
    }
}
