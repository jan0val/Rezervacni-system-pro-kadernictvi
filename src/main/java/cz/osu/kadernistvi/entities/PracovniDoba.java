package cz.osu.kadernistvi.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Pracovni_doba")
public class PracovniDoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_pracovni_doba")
    private Long id;

    @Column(name = "Pracovni_doba")
    private LocalDateTime cas;

    @ManyToOne
    @JoinColumn(name = "Kadernik_ID_kadernik")
    private Kadernik kadernik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCas() {
        return cas;
    }

    public void setCas(LocalDateTime cas) {
        this.cas = cas;
    }

    public Kadernik getKadernik() {
        return kadernik;
    }

    public void setKadernik(Kadernik kadernik) {
        this.kadernik = kadernik;
    }
}