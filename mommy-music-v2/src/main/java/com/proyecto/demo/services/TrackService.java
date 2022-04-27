package com.proyecto.demo.services;

import com.proyecto.demo.entities.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public List<Track> getAll();
    public Optional<Track> findById(long id);
    public Optional<Track> save(Track track);
    public Optional<Track> update(Track track);
    public boolean delete(long id);
}
