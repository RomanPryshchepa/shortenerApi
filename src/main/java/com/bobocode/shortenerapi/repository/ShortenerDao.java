package com.bobocode.shortenerapi.repository;

import com.bobocode.shortenerapi.storage.ShortenerStorage;
import org.springframework.stereotype.Component;

@Component
public class ShortenerDao {
    private final ShortenerStorage shortenerStorage;

    public ShortenerDao(ShortenerStorage shortenerStorage) {
        this.shortenerStorage = shortenerStorage;
    }

    public String save(String url) {
        return shortenerStorage.save(url);
    }

    public String get(String shortUrl) {
        return shortenerStorage.get(shortUrl);
    }
}
