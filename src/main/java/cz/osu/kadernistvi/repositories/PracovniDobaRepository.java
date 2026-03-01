package cz.osu.kadernistvi.repositories;

import cz.osu.kadernistvi.entities.PracovniDoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracovniDobaRepository extends JpaRepository<PracovniDoba, Long> {
}