import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaVozila {
    private List<Vozilo> listaVozila;

    public EvidencijaVozila() {
        this.listaVozila = new ArrayList<>();
    }

    public void dodajVozilo(Vozilo vozilo) {
        this.listaVozila.add(vozilo);
    }

    public void prikaziSvaVozila() {
        System.out.println("EVIDENCIJA SVIH VOZILA");
        if (listaVozila.isEmpty()) {
            System.out.println("Evidencija je prazna.");
            return;
        }
        for (Vozilo v : this.listaVozila) {
            v.prikaziPodatke();
            System.out.println("--------------------");
        }
    }

    public void spremiPodatkeUDatoteku(String nazivDatoteke) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nazivDatoteke)))) {
            for (Vozilo vozilo : this.listaVozila) {
                out.println(vozilo.zaDatoteku());
            }
        }
    }

    public void ucitajPodatkeIzDatoteke(String nazivDatoteke) throws IOException, NeispravniPodaciException {
        listaVozila.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(nazivDatoteke))) {
            String red;
            while ((red = reader.readLine()) != null) {
                String[] dijelovi = red.split(",");
                if (dijelovi.length < 4) {
                    System.err.println("UPOZORENJE: Neispravan format retka, preskačem: " + red);
                    continue;
                }

                String tipVozila = dijelovi[0];
                String registarskiBroj = dijelovi[1];
                String marka = dijelovi[2];
                int godinaProizvodnje;

                try {
                    godinaProizvodnje = Integer.parseInt(dijelovi[3]);
                } catch (NumberFormatException e) {
                    System.err.println("UPOZORENJE: Neispravna godina proizvodnje, preskačem redak: " + red);
                    continue;
                }

                if (tipVozila.equals("Automobil")) {
                    if (dijelovi.length != 5) {
                        System.err.println("UPOZORENJE: Neispravan broj argumenata za Automobil, preskačem redak: " + red);
                        continue;
                    }
                    int brojVrata;
                    try {
                        brojVrata = Integer.parseInt(dijelovi[4]);
                    } catch (NumberFormatException e) {
                        System.err.println("UPOZORENJE: Neispravan broj vrata, preskačem redak: " + red);
                        continue;
                    }
                    Automobil auto = new Automobil(registarskiBroj, marka, godinaProizvodnje, brojVrata);
                    listaVozila.add(auto);
                } else if (tipVozila.equals("Motocikl")) {
                    if (dijelovi.length != 5) {
                        System.err.println("UPOZORENJE: Neispravan broj argumenata za Motocikl, preskačem redak: " + red);
                        continue;
                    }
                    String tipMotora = dijelovi[4];
                    Motocikl moto = new Motocikl(registarskiBroj, marka, godinaProizvodnje, tipMotora);
                    listaVozila.add(moto);
                }
            }
        }
    }
}