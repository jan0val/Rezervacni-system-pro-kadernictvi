package cz.osu.kadernistvi.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Rezervace")
public class Rezervace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_rezervace")
    private Long id;

    @Column(name = "cas_zacatku")
    private LocalDateTime casZacatku;

    @Column(name = "cas_konce")
    private LocalDateTime casKonce;

    private String status;

    @ManyToOne
    @JoinColumn(name = "Zakaznik_ID_zakaznik")
    private Zakaznik zakaznik;

    @ManyToOne
    @JoinColumn(name = "Kadernik_ID_kadernik")
    private Kadernik kadernik;

    @ManyToMany
    @JoinTable(
            name = "Rezervace_Sluzba",
            joinColumns = @JoinColumn(name = "Rezervace_ID_rezervace"),
            inverseJoinColumns = @JoinColumn(name = "Sluzba_ID_sluzba")
    )
    private List<Sluzba> sluzby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCasZacatku() {
        return casZacatku;
    }

    public void setCasZacatku(LocalDateTime casZacatku) {
        this.casZacatku = casZacatku;
    }

    public LocalDateTime getCasKonce() {
        return casKonce;
    }

    public void setCasKonce(LocalDateTime casKonce) {
        this.casKonce = casKonce;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Zakaznik getZakaznik() {
        return zakaznik;
    }

    public void setZakaznik(Zakaznik zakaznik) {
        this.zakaznik = zakaznik;
    }

    public Kadernik getKadernik() {
        return kadernik;
    }

    public void setKadernik(Kadernik kadernik) {
        this.kadernik = kadernik;
    }

    public List<Sluzba> getSluzby() {
        return sluzby;
    }

    public void setSluzby(List<Sluzba> sluzby) {
        this.sluzby = sluzby;
    }
}