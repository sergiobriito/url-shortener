package com.api.urlshortener.repositories;

import com.api.urlshortener.models.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlModel, String> {
    Optional<UrlModel> findById(String id);
    Optional<UrlModel> findByUrl(String url);
    Optional<UrlModel> findByShortened(String shortened);
}
