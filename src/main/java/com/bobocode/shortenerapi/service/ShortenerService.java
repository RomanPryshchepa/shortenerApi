package com.bobocode.shortenerapi.service;

import com.bobocode.shortenerapi.repository.ShortenerDao;
import org.springframework.stereotype.Service;

@Service
public class ShortenerService {
    private final ShortenerDao shortenerDao;

    public ShortenerService(ShortenerDao shortenerDao) {
        this.shortenerDao = shortenerDao;
    }

    public String saveUrl(String url) {
        return shortenerDao.save(url);
    }

    public String getUrl(String shortUrl) {
        return shortenerDao.get(shortUrl);
    }
}
