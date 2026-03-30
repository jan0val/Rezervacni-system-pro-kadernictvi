package cz.osu.kadernistvi.controllers;

import cz.osu.kadernistvi.entities.Sluzba;
import cz.osu.kadernistvi.repositories.SluzbaRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sluzby") // Cesta pro služby
public class SluzbaController {

    private final SluzbaRepository sluzbaRepository;

    public SluzbaController(SluzbaRepository sluzbaRepository) {
        this.sluzbaRepository = sluzbaRepository;
    }

    // Pro zobrazení všech služeb
    @GetMapping
    public List<Sluzba> getAll() {
        return sluzbaRepository.findAll();
    }

    // Pro uložení nové služby
    @PostMapping("/add")
    public String addSluzba(@Valid @RequestBody Sluzba sluzba) {
        sluzbaRepository.save(sluzba);
        return "Služba " + sluzba.getDruhStrihu() + " s cenou " + sluzba.getCena() + " Kč byla úspěšně přidána do systému!";
    }
}

