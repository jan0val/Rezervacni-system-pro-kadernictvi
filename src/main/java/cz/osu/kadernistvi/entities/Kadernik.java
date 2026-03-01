package cz.osu.kadernistvi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Kadernik")
public class Kadernik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_kadernik")
    private Long id;

    private String jmeno;

    @OneToMany(mappedBy = "kadernik")
    private List<Rezervace> rezervace;

    @OneToMany(mappedBy = "kadernik")
    private List<PracovniDoba> pracovniDoby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public List<Rezervace> getRezervace() {
        return rezervace;
    }

    public void setRezervace(List<Rezervace> rezervace) {
        this.rezervace = rezervace;
    }

    public List<PracovniDoba> getPracovniDoby() {
        return pracovniDoby;
    }

    public void setPracovniDoby(List<PracovniDoba> pracovniDoby) {
        this.pracovniDoby = pracovniDoby;
    }
}