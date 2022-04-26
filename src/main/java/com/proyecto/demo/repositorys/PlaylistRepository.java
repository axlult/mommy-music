package com.cenfotec.mommysmusic.mommysmusic.repository;

import com.cenfotec.mommysmusic.mommysmusic.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
