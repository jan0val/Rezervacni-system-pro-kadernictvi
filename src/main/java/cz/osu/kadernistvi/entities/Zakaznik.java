package cz.osu.kadernistvi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Zakaznik")
public class Zakaznik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_zakaznik")
    private Long id;

    private String jmeno;
    private String tel;
    private String email;

    @OneToMany(mappedBy = "zakaznik")
    private List<Rezervace> rezervace;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rezervace> getRezervace() {
        return rezervace;
    }

    public void setRezervace(List<Rezervace> rezervace) {
        this.rezervace = rezervace;
    }
}