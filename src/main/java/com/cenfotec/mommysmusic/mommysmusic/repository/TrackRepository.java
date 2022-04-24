package com.cenfotec.mommysmusic.mommysmusic.repository;

import com.cenfotec.mommysmusic.mommysmusic.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TracksRepository extends JpaRepository<Track, Long> {
}
