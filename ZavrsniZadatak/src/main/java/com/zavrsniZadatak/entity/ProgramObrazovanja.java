package com.zavrsniZadatak.entity;

public class ProgramObrazovanja {

    private int id;
    private String naziv;
    private int csvet;

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
