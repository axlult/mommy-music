package com.proyecto.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String mediaType;
    private String miliseconds;
    private String bytes;
    private String compositor;
    private String trackURL;

    public Track() {
    }

    public Track(Long id, String name, String mediaType, String miliseconds, String bytes, String compositor, String trackURL) {
        this.id = id;
        this.name = name;
        this.mediaType = mediaType;
        this.miliseconds = miliseconds;
        this.bytes = bytes;
        this.compositor = compositor;
        this.trackURL = trackURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMiliseconds() {
        return miliseconds;
    }

    public void setMiliseconds(String miliseconds) {
        this.miliseconds = miliseconds;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getTrackURL() {
        return trackURL;
    }

    public void setTrackURL(String trackURL) {
        this.trackURL = trackURL;
    }
}