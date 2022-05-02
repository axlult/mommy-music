package com.proyecto.demo.controllers;

import com.proyecto.demo.entities.Track;
import com.proyecto.demo.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping({"/tracks"})
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping
    public Iterable<Track> getAll(){
        return trackService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Track> findById(@PathVariable String id){
        Optional<Track> result = trackService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Track create(@RequestBody Track track) {
        return trackService.save(track).get();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Track> update(@PathVariable("id") String id, @RequestBody Track track){
        track.setId(id);
        Optional<Track> result = trackService.update(track);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        if (trackService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
