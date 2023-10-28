package com.bobocode.shortenerapi.storage;

import com.bobocode.shortenerapi.utils.ShortenerUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.isNull;

@Component
public class ShortenerStorage {
    private static Map<String, String> shortenerStorage;

    public String save(String url) {
        if (isNull(shortenerStorage)) {
            shortenerStorage = new ConcurrentHashMap<>();
        }
        for (Map.Entry<String, String> entry : shortenerStorage.entrySet()) {
            if (entry.getValue().equals(url)) {
                return entry.getKey();
            }
        }
        String shortUrl = ShortenerUtils.generateShortForUrl();
        while (shortenerStorage.containsKey(shortUrl)) {
            shortUrl = ShortenerUtils.generateShortForUrl();
        }
        shortenerStorage.put(shortUrl, url);
        return shortUrl;
    }

    public String get(String shortUrl) {
        return shortenerStorage.get(shortUrl);
    }
}
