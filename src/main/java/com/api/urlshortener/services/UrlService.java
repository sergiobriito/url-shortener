package com.api.urlshortener.services;

import com.api.urlshortener.dtos.UrlDto;
import com.api.urlshortener.models.UrlModel;
import com.api.urlshortener.repositories.UrlRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.api.urlshortener.utils.Base62Converter.encodeToBase62;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    };

    public UrlModel save(UrlDto urlDto){
        UrlModel urlModel = new UrlModel();
        UUID uuid = UUID.randomUUID();
        String shortenedUrl = encodeToBase62(uuid.toString());
        urlModel.setUuid(uuid);
        urlModel.setShortened(shortenedUrl);
        BeanUtils.copyProperties(urlDto, urlModel);
        urlRepository.save(urlModel);
        return urlModel;
    };

    public Optional<UrlModel> findById(UUID uuid){
        return urlRepository.findById(uuid);
    };

    public Optional<UrlModel> findByUrl(String url){
        return urlRepository.findByUrl(url);
    };

    public Optional<UrlModel> findByShortened(String shortened){
        return urlRepository.findByShortened(shortened);
    };
}
