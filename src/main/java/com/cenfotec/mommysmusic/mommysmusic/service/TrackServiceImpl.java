package com.cenfotec.mommysmusic.mommysmusic.service;

import com.cenfotec.mommysmusic.mommysmusic.domain.Track;
import com.cenfotec.mommysmusic.mommysmusic.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    @Autowired
    TrackRepository trackRepository;

    @Override
    public List<Track> getAll() {
        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> findById(long id) {
        return trackRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public Optional<Track> save(Track track) {
        return Optional.of(trackRepository.save(track));
    }

    @Override
    public Optional<Track> update(Track track) {
        Optional<Track> record = trackRepository.findById(track.getId());
        if (record.isPresent()) {
            Track data = record.get();
            data.setName(track.getName());
            data.setCompositor(track.getCompositor());
            data.setMediaType(track.getMediaType());
            data.setBytes(track.getBytes());
            data.setMiliseconds(track.getMiliseconds());
            data.setTrackURL(track.getTrackURL());
            return Optional.of(trackRepository.save(data));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        Optional<Track> result = trackRepository.findById(id);
        if(result.isPresent()){
            trackRepository.deleteById(id);
            return true;
        }
        return false;
    }
}