package com.zavrsniZadatak.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Upis")
public class Upis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UpisId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "IDPolaznik", nullable = false)
    private Polaznik polaznik;

    @ManyToOne
    @JoinColumn(name = "IDProgramObrazovanja", nullable = false)
    private ProgramObrazovanja programObrazovanja;

    public Upis() {
    }

    public Upis(Polaznik polaznik, ProgramObrazovanja programObrazovanja) {
        this.polaznik = polaznik;
        this.programObrazovanja = programObrazovanja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Polaznik getPolaznik() {
        return polaznik;
    }

    public void setPolaznik(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public ProgramObrazovanja getProgramObrazovanja() {
        return programObrazovanja;
    }

    public void setProgramObrazovanja(ProgramObrazovanja programObrazovanja) {
        this.programObrazovanja = programObrazovanja;
    }

    @Override
    public String toString() {
        String polaznikIme = (polaznik != null) ? polaznik.getIme() : "null";
        String programNaziv = (programObrazovanja != null) ? programObrazovanja.getNaziv() : "null";
        return "Upis [id=" + id + ", polaznik=" + polaznikIme + ", program=" + programNaziv + "]";
    }
}