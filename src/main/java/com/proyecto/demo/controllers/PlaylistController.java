package com.cenfotec.mommysmusic.mommysmusic.controller;

import com.cenfotec.mommysmusic.mommysmusic.domain.Playlist;
import com.cenfotec.mommysmusic.mommysmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/playlist"})
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List getAll(){
        return PlaylistService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Playlist> findById(@PathVariable long id){
        Optional<Playlist> result = PlaylistService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Playlist create(@RequestBody Playlist playlist) {
        return PlaylistService.save(Playlist).get();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Playlist> update(@PathVariable("id") long id, @RequestBody Playlist playlist){
        Playlist.setId(id);
        Optional<Playlist> result = PlaylistService.update(playlist);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        if (playlistService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
