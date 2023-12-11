package com.api.urlshortener.repositories;

import com.api.urlshortener.models.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UrlRepository extends JpaRepository<UrlModel, UUID> {
    Optional<UrlModel> findById(UUID uuid);
    Optional<UrlModel> findByUrl(String url);
    Optional<UrlModel> findByShortened(String shortened);
}
