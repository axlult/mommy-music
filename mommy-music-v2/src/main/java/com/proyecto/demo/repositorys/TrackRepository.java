package com.proyecto.demo.repositorys;

import com.proyecto.demo.entities.Track;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface TrackRepository extends CrudRepository<Track, String> {
}
