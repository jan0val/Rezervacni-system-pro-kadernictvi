package cz.osu.kadernistvi.repositories;

import cz.osu.kadernistvi.entities.Rezervace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervaceRepository extends JpaRepository<Rezervace, Long> {
}