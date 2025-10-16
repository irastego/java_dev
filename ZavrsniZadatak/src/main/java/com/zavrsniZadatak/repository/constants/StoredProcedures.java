package com.zavrsniZadatak.repository.constants;

public class StoredProcedures {
    public static final String DODAJ_POLAZNIKA = "{call dbo.DodajPolaznika (?, ?)}";
    public static final String DODAJ_PROGRAM_OBRAZOVANJA = "{call dbo.DodajProgramObrazovania (?, ?)}";
    public static final String UPISI_PROGRAM_OBRAZOVANJA = "{call dbo.UpisiProgramObrazovanja (?, ?)}";
    public static final String DOHVATI_PROGRAME_OBRAZOVANJA = "{call dbo.DohvatiProgrameObrazovanja (?, ?)}";
    public static final String DOHVATI_POLAZNIKE = "{call dbo.DohvatiPolaznike)}";
    public static final String PREBACI_POLAZNIKA = "{call dbo.PrebaciPolaznika (?, ?, ?)}";
    public static final String ISPISI_POLAZNIKE_NA_PROGRAMU = "{call dbo.IspisiPolaznikeNaProgramu(?)}";
}
