package com.proyecto.demo.services;

import com.proyecto.demo.entities.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {

    public Iterable<Playlist> getAll();
    public Optional<Playlist> findById(String id);
    public Optional<Playlist> save(Playlist playlist);
    public Optional<Playlist> update(Playlist playlist);
    public boolean delete(String id);
}
