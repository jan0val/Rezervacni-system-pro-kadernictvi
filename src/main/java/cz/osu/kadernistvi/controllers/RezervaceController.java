package cz.osu.kadernistvi.controllers;

import cz.osu.kadernistvi.dto.RezervaceDTO;
import cz.osu.kadernistvi.entities.Rezervace;
import cz.osu.kadernistvi.services.RezervaceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller pro správu rezervací.
 * Poskytuje API endpointy pro vytváření a správu rezervací.
 */
@CrossOrigin
@RestController
@RequestMapping("/rezervace")
public class RezervaceController {

    private final RezervaceService rezervaceService;

    public RezervaceController(RezervaceService rezervaceService) {
        this.rezervaceService = rezervaceService;
    }

    /**
     * Vrátí seznam všech rezervací.
     *
     * @return List všech rezervací
     */
    @GetMapping
    public List<Rezervace> getAllRezervace() {
        return rezervaceService.getVsechnyRezervace();
    }

    /**
     * Vytvoří novou rezervaci.
     *
     * @param rezervaceDTO DTO s daty pro vytvoření rezervace
     * @return Textové potvrzení o úspěšném vytvoření
     */
    @PostMapping("/add")
    public String addRezervace(@Valid @RequestBody RezervaceDTO rezervaceDTO) {
        Rezervace vytvorena = rezervaceService.vytvorRezervaci(rezervaceDTO);
        return "Rezervace č. " + vytvorena.getId() + " byla úspěšně vytvořena! Začíná v " + vytvorena.getCasZacatku() +
               " a končí v " + vytvorena.getCasKonce();
    }
}

