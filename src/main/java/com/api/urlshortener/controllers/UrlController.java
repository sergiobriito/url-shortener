package com.api.urlshortener.controllers;

import com.api.urlshortener.dtos.UrlDto;
import com.api.urlshortener.models.UrlModel;
import com.api.urlshortener.services.UrlService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/url-shortener")
public class UrlController {

    private final UrlService urlService;

    @Value("${domain.url}")
    private String domainUrl;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> saveUrl(@RequestBody @Valid UrlDto urlDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid url data.");
        };

        if (urlService.findByUrl(urlDto.getUrl()).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Url already in use.");
        };

        return ResponseEntity.status(HttpStatus.CREATED).body(domainUrl+urlService.save(urlDto).getShortened());
    };

    @GetMapping("/{shortenedUrl}")
    public ResponseEntity<Object> getUrl(@PathVariable(value = "shortenedUrl") String shortenedUrl){
        Optional<UrlModel> urlModel = urlService.findByShortened(shortenedUrl);
        if (urlModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Url not found.");
        };
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", urlModel.get().getUrl());
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }


}
