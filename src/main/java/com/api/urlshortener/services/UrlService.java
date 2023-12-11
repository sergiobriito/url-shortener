package com.api.urlshortener.services;

import com.api.urlshortener.dtos.UrlDto;
import com.api.urlshortener.models.UrlModel;
import com.api.urlshortener.repositories.UrlRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.api.urlshortener.utils.Base62Converter.encodeToBase62;
import static com.api.urlshortener.utils.IdGenerator.generateSnowflakeId;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    };

    public UrlModel save(UrlDto urlDto){
        UrlModel urlModel = new UrlModel();
        String id = generateSnowflakeId();
        String shortenedUrl = encodeToBase62(id);
        urlModel.setId(id);
        urlModel.setShortened(shortenedUrl);
        BeanUtils.copyProperties(urlDto, urlModel);
        urlRepository.save(urlModel);
        return urlModel;
    };

    public Optional<UrlModel> findById(String id){
        return urlRepository.findById(id);
    };

    public Optional<UrlModel> findByUrl(String url){
        return urlRepository.findByUrl(url);
    };

    public Optional<UrlModel> findByShortened(String shortened){
        return urlRepository.findByShortened(shortened);
    };
}
