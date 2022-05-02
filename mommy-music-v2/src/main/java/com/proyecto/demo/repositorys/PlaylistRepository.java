package com.proyecto.demo.repositorys;

import com.proyecto.demo.entities.Playlist;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, String> {
}
