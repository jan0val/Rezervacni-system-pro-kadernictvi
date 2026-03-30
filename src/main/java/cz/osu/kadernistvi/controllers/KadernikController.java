package cz.osu.kadernistvi.controllers;

import cz.osu.kadernistvi.entities.Kadernik;
import cz.osu.kadernistvi.repositories.KadernikRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/kadernici") // Cesta pro kadeřníky
public class KadernikController {

    private final KadernikRepository kadernikRepository;

    public KadernikController(KadernikRepository kadernikRepository) {
        this.kadernikRepository = kadernikRepository;
    }

    // Pro zobrazení všech kadeřníků
    @GetMapping
    public List<Kadernik> getAll() {
        return kadernikRepository.findAll();
    }

    // Pro uložení nového kadeřníka
    @PostMapping("/add")
    public String addKadernik(@Valid @RequestBody Kadernik kadernik) {
        kadernikRepository.save(kadernik);
        return "Kadeřník " + kadernik.getJmeno() + " byl úspěšně přidán do systému!";
    }
}

