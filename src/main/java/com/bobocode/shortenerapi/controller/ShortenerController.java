package com.bobocode.shortenerapi.controller;

import com.bobocode.shortenerapi.dto.UrlDto;
import com.bobocode.shortenerapi.service.ShortenerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shortener")
public class ShortenerController {
    private final ShortenerService shortenerService;

    public ShortenerController(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @PostMapping()
    public ResponseEntity<String> saveUrl(@RequestBody UrlDto urlDto) {
        String shortUrl = "http://localhost:8080/shortener/".concat(shortenerService.saveUrl(urlDto.url()));
        return ResponseEntity.status(HttpStatus.OK).body(shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getUrl(@PathVariable String shortUrl) {
        String url = shortenerService.getUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, url).build();
    }
}
