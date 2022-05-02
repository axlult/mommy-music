package com.proyecto.demo.controllers;

import com.proyecto.demo.entities.Playlist;
import com.proyecto.demo.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping({"/playlist"})
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public Iterable<Playlist> getAll(){
        return playlistService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Playlist> findById(@PathVariable String id){
        Optional<Playlist> result = playlistService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Playlist create(@RequestBody Playlist playlist) {
        return playlistService.save(playlist).get();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Playlist> update(@PathVariable("id") String id, @RequestBody Playlist playlist){
        playlist.setId(id);
        Optional<Playlist> result = playlistService.update(playlist);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        if (playlistService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}