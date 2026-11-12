package com.kari3600.me.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static String[] splitEscapeQuotation(String input) {
        return splitEscapeQuotation(input, ' ');
    }

    public static String[] splitEscapeQuotation(String input, char delimiter) {
        List<String> result = new ArrayList<>();
        StringBuilder token = new StringBuilder();
        char quote = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if ((c == '"' || c == '\'') && (quote == 0 || quote == c)) {
                quote = (quote == 0) ? c : 0;
                token.append(c);
            } else if (c == delimiter && quote == 0) {
                if (!token.isEmpty()) {
                    result.add(token.toString());
                    token.setLength(0);
                }
            } else {
                token.append(c);
            }
        }

        if (!token.isEmpty()) {
            result.add(token.toString());
        }

        return result.toArray(String[]::new);
    }
}
