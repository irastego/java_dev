package com.zavrsniZadatak.repository;

import com.zavrsniZadatak.entity.Polaznik;
import com.zavrsniZadatak.repository.constants.StoredProcedures;
import com.zavrsniZadatak.repository.utility.SQLDataSourceUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PolaznikRepository {
    public void dodaj(Polaznik polaznik) {
        try (Connection conn = SQLDataSourceUtil.getSQLServerDataSource().getConnection();
             CallableStatement cs = conn.prepareCall(StoredProcedures.DODAJ_POLAZNIKA)) {

            cs.setString(1, polaznik.getIme());
            cs.setString(2, polaznik.getPrezime());
            cs.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Polaznik> dohvati(){
        ArrayList<Polaznik> polaznikList = new ArrayList<>();

        try (Connection conn = SQLDataSourceUtil.getSQLServerDataSource().getConnection();
             CallableStatement cs = conn.prepareCall(StoredProcedures.DOHVATI_POLAZNIKE)) {

            cs.execute();
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int idPolaznik = rs.getInt("PolaznikID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");

                polaznikList.add(new Polaznik(idPolaznik, ime, prezime));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return polaznikList;
    }
}
