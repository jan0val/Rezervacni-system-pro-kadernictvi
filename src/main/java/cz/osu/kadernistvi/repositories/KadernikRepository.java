package cz.osu.kadernistvi.repositories;

import cz.osu.kadernistvi.entities.Kadernik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KadernikRepository extends JpaRepository<Kadernik, Long> {
}