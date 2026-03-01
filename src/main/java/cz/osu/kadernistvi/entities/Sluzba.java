package cz.osu.kadernistvi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sluzba")
public class Sluzba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_sluzba")
    private Long id;

    @Column(name = "druh_strihu")
    private String druhStrihu;

    private Double cena;

    @ManyToMany(mappedBy = "sluzby")
    private List<Rezervace> rezervace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDruhStrihu() {
        return druhStrihu;
    }

    public void setDruhStrihu(String druhStrihu) {
        this.druhStrihu = druhStrihu;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public List<Rezervace> getRezervace() {
        return rezervace;
    }

    public void setRezervace(List<Rezervace> rezervace) {
        this.rezervace = rezervace;
    }
}