package com.api.urlshortener.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_URL")
public class UrlModel implements Serializable {

    @Id
    @Column(length = 19)
    private String id;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false,length = 26)
    private String shortened;

    public UrlModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
