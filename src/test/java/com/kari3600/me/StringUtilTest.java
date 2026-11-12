package com.kari3600.me;

import org.junit.jupiter.api.Test;

import static com.kari3600.me.utils.StringUtil.splitEscapeQuotation;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringUtilTest {
    @Test
    public void test1() {
        assertArrayEquals(new String[]{"a", "b", "\"c d\""}, splitEscapeQuotation("a b \"c d\""));
    }
}
