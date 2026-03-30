package cz.osu.kadernistvi.controllers;

import cz.osu.kadernistvi.entities.Zakaznik;
import cz.osu.kadernistvi.repositories.ZakaznikRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test") // Všechny adresy budou začínat /test
public class TestController {

    private final ZakaznikRepository zakaznikRepository;

    public TestController(ZakaznikRepository zakaznikRepository) {
        this.zakaznikRepository = zakaznikRepository;
    }

    // Adresa: localhost:8081/test/napln
    @GetMapping("/napln")
    public String naplnDatabazi() {
        Zakaznik z1 = new Zakaznik();
        z1.setJmeno("Petr Novák");
        z1.setTel("777 123 456");
        z1.setEmail("petr@novak.cz");
        zakaznikRepository.save(z1);

        return "Zákazník Petr Novák byl přidán do databáze!";
    }

    // Adresa: localhost:8081/test/vypis
    @GetMapping("/vypis")
    public List<Zakaznik> vypisVsechny() {
        return zakaznikRepository.findAll();
    }
}