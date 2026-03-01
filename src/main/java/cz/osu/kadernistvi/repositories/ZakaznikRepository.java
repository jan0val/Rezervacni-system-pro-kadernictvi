package cz.osu.kadernistvi.repositories;

import cz.osu.kadernistvi.entities.Zakaznik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZakaznikRepository extends JpaRepository<Zakaznik, Long> {
}