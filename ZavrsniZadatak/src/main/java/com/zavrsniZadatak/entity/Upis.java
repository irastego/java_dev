package com.zavrsniZadatak.entity;

public class Upis {
    private int id;
    private int idPolaznik;
    private int idProgramObrazovanja;

    public Upis(int id, int idPolaznik, int idProgramObrazovanja) {
        this.id = id;
        this.idPolaznik = idPolaznik;
        this.idProgramObrazovanja = idProgramObrazovanja;
    }

    public Upis(int idPolaznik, int idProgramObrazovanja) {
        this.idPolaznik = idPolaznik;
        this.idProgramObrazovanja = idProgramObrazovanja;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPolaznik() {
        return idPolaznik;
    }

    public void setIdPolaznik(int idPolaznik) {
        this.idPolaznik = idPolaznik;
    }

    public int getIdProgramObrazovanja() {
        return idProgramObrazovanja;
    }

    public void setIdProgramObrazovanja(int idProgramObrazovanja) {
        this.idProgramObrazovanja = idProgramObrazovanja;
    }

    @Override
    public String toString() {
        return "Upis [ID=" + id + ", ID Polaznika=" + idPolaznik + ", ID Programa=" + idProgramObrazovanja + "]";
    }
}
