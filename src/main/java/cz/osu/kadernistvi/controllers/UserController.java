package cz.osu.kadernistvi.controllers;

import cz.osu.kadernistvi.entities.Zakaznik;
import cz.osu.kadernistvi.repositories.ZakaznikRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users") // Tohle je tvá hlavní adresa pro uživatele
public class UserController {

    private final ZakaznikRepository zakaznikRepository;

    public UserController(ZakaznikRepository zakaznikRepository) {
        this.zakaznikRepository = zakaznikRepository;
    }

    // Pro zobrazení všech (v uzivatele.html)
    @GetMapping
    public List<Zakaznik> getAll() {
        return zakaznikRepository.findAll();
    }

    // Pro uložení nového (v index.html)
    @PostMapping("/add")
    public String addUser(@Valid @RequestBody Zakaznik zakaznik) {
        zakaznikRepository.save(zakaznik);
        return "Uživatel " + zakaznik.getJmeno() + " byl úspěšně přidán do systému kadeřnictví!";
    }
}

