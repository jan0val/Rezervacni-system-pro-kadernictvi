package cz.osu.kadernistvi.dto;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) pro přenos dat o rezervaci z frontendu na backend.
 * Obsahuje pouze ID a čas bez kompletních entit.
 */
public class RezervaceDTO {
    private Long zakaznikId;
    private Long kadernikId;
    private Long sluzbaId;
    private LocalDateTime casZacatku;

    // Konstruktory
    public RezervaceDTO() {
    }

    public RezervaceDTO(Long zakaznikId, Long kadernikId, Long sluzbaId, LocalDateTime casZacatku) {
        this.zakaznikId = zakaznikId;
        this.kadernikId = kadernikId;
        this.sluzbaId = sluzbaId;
        this.casZacatku = casZacatku;
    }

    // Gettery a settery
    public Long getZakaznikId() {
        return zakaznikId;
    }

    public void setZakaznikId(Long zakaznikId) {
        this.zakaznikId = zakaznikId;
    }

    public Long getKadernikId() {
        return kadernikId;
    }

    public void setKadernikId(Long kadernikId) {
        this.kadernikId = kadernikId;
    }

    public Long getSluzbaId() {
        return sluzbaId;
    }

    public void setSluzbaId(Long sluzbaId) {
        this.sluzbaId = sluzbaId;
    }

    public LocalDateTime getCasZacatku() {
        return casZacatku;
    }

    public void setCasZacatku(LocalDateTime casZacatku) {
        this.casZacatku = casZacatku;
    }
}

