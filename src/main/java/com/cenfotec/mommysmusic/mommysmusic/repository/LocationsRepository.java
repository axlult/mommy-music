package com.cenfotec.mommysmusic.mommysmusic.repository;

import com.cenfotec.mommysmusic.mommysmusic.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends JpaRepository<Location, Long> {
}
