package com.api.urlshortener.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_URL")
public class UrlModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID uuid;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String shortened;

    public UrlModel() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortened() {
        return shortened;
    }

    public void setShortened(String shortened) {
        this.shortened = shortened;
    }
}
