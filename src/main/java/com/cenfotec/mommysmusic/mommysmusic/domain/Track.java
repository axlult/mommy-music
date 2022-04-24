package com.cenfotec.mommysmusic.mommysmusic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tracks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String mediaType;
    private String miliseconds;
    private String bytes;
    private String compositor;
    private String trackURL;
}