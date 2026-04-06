package cz.osu.kadernistvi.services;

import cz.osu.kadernistvi.dto.RezervaceDTO;
import cz.osu.kadernistvi.entities.Kadernik;
import cz.osu.kadernistvi.entities.Rezervace;
import cz.osu.kadernistvi.entities.Sluzba;
import cz.osu.kadernistvi.entities.Zakaznik;
import cz.osu.kadernistvi.repositories.KadernikRepository;
import cz.osu.kadernistvi.repositories.RezervaceRepository;
import cz.osu.kadernistvi.repositories.SluzbaRepository;
import cz.osu.kadernistvi.repositories.ZakaznikRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service vrstva pro správu rezervací.
 * Obsahuje business logiku pro vytváření a správu rezervací.
 */
@Service
public class RezervaceService {

    private final RezervaceRepository rezervaceRepository;
    private final ZakaznikRepository zakaznikRepository;
    private final KadernikRepository kadernikRepository;
    private final SluzbaRepository sluzbaRepository;

    public RezervaceService(RezervaceRepository rezervaceRepository,
                           ZakaznikRepository zakaznikRepository,
                           KadernikRepository kadernikRepository,
                           SluzbaRepository sluzbaRepository) {
        this.rezervaceRepository = rezervaceRepository;
        this.zakaznikRepository = zakaznikRepository;
        this.kadernikRepository = kadernikRepository;
        this.sluzbaRepository = sluzbaRepository;
    }

    /**
     * Vytvoří novou rezervaci na základě DTO.
     *
     * @param dto DTO obsahující ID zákazníka, kadeřníka, služby a čas začátku
     * @return Vytvořená rezervace
     * @throws RuntimeException pokud není nalezen zákazník, kadeřník nebo služba
     */
    public Rezervace vytvorRezervaci(RezervaceDTO dto) {
        // 1. Najdeme příslušné entity v databázi
        Zakaznik zakaznik = zakaznikRepository.findById(dto.getZakaznikId())
                .orElseThrow(() -> new RuntimeException("Zákazník s ID " + dto.getZakaznikId() + " nebyl nalezen!"));

        Kadernik kadernik = kadernikRepository.findById(dto.getKadernikId())
                .orElseThrow(() -> new RuntimeException("Kadeřník s ID " + dto.getKadernikId() + " nebyl nalezen!"));

        Sluzba sluzba = sluzbaRepository.findById(dto.getSluzbaId())
                .orElseThrow(() -> new RuntimeException("Služba s ID " + dto.getSluzbaId() + " nebyla nalezena!"));

        // 2. Vytvoříme novou instanci Rezervace
        Rezervace rezervace = new Rezervace();

        // 3. Nastavíme nalezené objekty
        rezervace.setZakaznik(zakaznik);
        rezervace.setKadernik(kadernik);
        rezervace.setSluzby(java.util.Arrays.asList(sluzba));

        // 4. Nastavíme čas začátku
        rezervace.setCasZacatku(dto.getCasZacatku());

        // 5. Vypočítáme čas konce (casZacatku + delkaVMinutach)
        if (sluzba.getDelkaVMinutach() != null) {
            LocalDateTime casKonce = dto.getCasZacatku().plusMinutes(sluzba.getDelkaVMinutach());
            rezervace.setCasKonce(casKonce);
        } else {
            // Pokud není nastavena délka, nastavíme stejný čas
            rezervace.setCasKonce(dto.getCasZacatku());
        }

        // 6. Nastavíme výchozí status
        rezervace.setStatus("POTVRZENA");

        // 7. Uložíme a vrátíme vytvořenou rezervaci
        return rezervaceRepository.save(rezervace);
    }

    /**
     * Vrátí seznam všech rezervací.
     *
     * @return List všech rezervací
     */
    public List<Rezervace> getVsechnyRezervace() {
        return rezervaceRepository.findAll();
    }
}

