package com.zavrsniZadatak.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ProgramObrazovanja")
public class ProgramObrazovanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProgramObrazovanjaId")
    private int id;

    @Column(name = "Naziv")
    private String naziv;

    @Column(name = "CSVET")
    private int csvet;

    public ProgramObrazovanja() {}

    public ProgramObrazovanja(int id, String naziv, int csvet) {
        this.id = id;
        this.naziv = naziv;
        this.csvet = csvet;
    }

    public ProgramObrazovanja(String naziv, int csvet) {
        this.naziv = naziv;
        this.csvet = csvet;
    }


    public int getId(){
        return id;
    }

    public String getNaziv(){
        return naziv;
    }

    public void setNaziv(String naziv){
        this.naziv = naziv;
    }

    public int getCsvet(){
        return csvet;
    }

    public void setCsvet(int csvet){
        this.csvet = csvet;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Naziv: " + this.naziv + ", CSVET: " + this.csvet;
    }
}
