package com.proyecto.demo.services;

import com.proyecto.demo.entities.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {

    public List<Playlist> getAll();
    public Optional<Playlist> findById(long id);
    public Optional<Playlist> save(Playlist playlist);
    public Optional<Playlist> update(Playlist playlist);
    public boolean delete(long id);
}