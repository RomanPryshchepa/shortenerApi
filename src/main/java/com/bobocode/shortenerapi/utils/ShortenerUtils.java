package com.bobocode.shortenerapi.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class ShortenerUtils {
    private static final String seq = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    public static String generateShortForUrl() {
        return getRandomString(seq, 4);
    }

    private static String getRandomSymbol(String seq) {
        int index = ThreadLocalRandom.current().nextInt(seq.length());
        return seq.substring(index, index + 1);
    }

    private static String getRandomString(String seq, int len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(getRandomSymbol(seq));
        }
        return stringBuilder.toString();
    }
}
