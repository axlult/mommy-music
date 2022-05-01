package com.proyecto.demo.services;

import com.proyecto.demo.entities.Playlist;
import com.proyecto.demo.repositorys.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(long id) {
        return playlistRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Playlist> save(Playlist playlist) {
        return Optional.of(playlistRepository.save(playlist));
    }

    @Override
    public Optional<Playlist> update(Playlist playlist) {
        Optional<Playlist> record = playlistRepository.findById(playlist.getId());
        if (record.isPresent()) {
            Playlist data = record.get();
            data.setName(playlist.getName());

            return Optional.of(playlistRepository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        Optional<Playlist> result = playlistRepository.findById(id);
        if(result.isPresent()){
            playlistRepository.deleteById(id);
            return true;
        }
        return false;
    }
}