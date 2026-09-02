package com.kari3600.me.utils.translator.primitive;

import com.kari3600.me.utils.translator.Translator;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class StringTranslators {
    public static final Translator<Boolean, String> BOOLEAN = new Translator<>() {
        @Override
        public String encode(Boolean input) {
            if (input == null) return null;
            return String.valueOf(input);
        }

        @Override
        public Boolean decode(String output) {
            if (output == null) return null;
            return Boolean.valueOf(output);
        }
    };

    public static final Translator<Integer, String> INTEGER = new Translator<>() {
        @Override
        public String encode(Integer input) {
            if (input == null) return null;
            return String.valueOf(input);
        }

        @Override
        public Integer decode(String output) {
            if (output == null) return null;
            return Integer.valueOf(output);
        }
    };

    public static final Translator<Long, String> LONG = new Translator<>() {
        @Override
        public String encode(Long input) {
            if (input == null) return null;
            return String.valueOf(input);
        }

        @Override
        public Long decode(String output) {
            if (output == null) return null;
            return Long.valueOf(output);
        }
    };

    public static final Translator<InetAddress, String> INET_ADDRESS = new Translator<>() {
        @Override
        public String encode(InetAddress input) {
            if (input == null) return null;
            return input.toString().substring(1);
        }

        @Override
        public InetAddress decode(String output) {
            if (output == null) return null;
            try {
                return InetAddress.getByName(output);
            } catch (UnknownHostException e) {
                throw new RuntimeException("Malformed IP address: " + output, e);
            }
        }
    };

    public static final Translator<Class<?>, String> CLASS = new Translator<>() {
        @Override
        public String encode(Class<?> input) {
            return input.getName();
        }

        @Override
        public Class<?> decode(String output) {
            try {
                return Class.forName(output);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public static final Translator<java.util.UUID, String> UUID = new Translator<>() {

        @Override
        public String encode(java.util.UUID input) {
            return input.toString();
        }

        @Override
        public java.util.UUID decode(String output) {
            return java.util.UUID.fromString(output);
        }
    };
}
