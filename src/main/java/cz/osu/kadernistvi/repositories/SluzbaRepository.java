package cz.osu.kadernistvi.repositories;

import cz.osu.kadernistvi.entities.Sluzba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SluzbaRepository extends JpaRepository<Sluzba, Long> {
}