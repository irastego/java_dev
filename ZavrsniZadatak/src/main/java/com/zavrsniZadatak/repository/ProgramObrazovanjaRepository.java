package com.zavrsniZadatak.repository;

import com.zavrsniZadatak.entity.ProgramObrazovanja;
import com.zavrsniZadatak.repository.constants.StoredProcedures;
import com.zavrsniZadatak.repository.utility.SQLDataSourceUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramObrazovanjaRepository {
    public void dodaj(ProgramObrazovanja po) {
        try (Connection conn = SQLDataSourceUtil.getSQLServerDataSource().getConnection();
             CallableStatement cs = conn.prepareCall(StoredProcedures.DODAJ_PROGRAM_OBRAZOVANJA)) {

            cs.setString(1, po.getNaziv());
            cs.setInt(2, po.getCsvet());
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ProgramObrazovanja> dohvati() {
        List<ProgramObrazovanja> programiObrazovanja = new ArrayList<>();
        try (Connection conn = SQLDataSourceUtil.getSQLServerDataSource().getConnection();
             CallableStatement cs = conn.prepareCall(StoredProcedures.DOHVATI_PROGRAME_OBRAZOVANJA);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ProgramObrazovanjaId");
                String naziv = rs.getString("Naziv");
                int csvet = rs.getInt("CSVET");
                programiObrazovanja.add(new ProgramObrazovanja(id, naziv, csvet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programiObrazovanja;
    }

    public void upisi(int polaznikId, int programId) {
        try (Connection conn = SQLDataSourceUtil.getSQLServerDataSource().getConnection();
             CallableStatement cs = conn.prepareCall(StoredProcedures.UPISI_PROGRAM_OBRAZOVANJA)) {

            cs.setInt(1, polaznikId);
            cs.setInt(2, programId);
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void prebaciPolaznika(int polaznikId, int stariProgramId, int noviProgramId) {
        Connection conn = null;
        try {
            conn = SQLDataSourceUtil.getSQLServerDataSource().getConnection();
            conn.setAutoCommit(false);

            try (CallableStatement cs = conn.prepareCall(StoredProcedures.PREBACI_POLAZNIKA)) {
                cs.setInt(1, polaznikId);
                cs.setInt(2, stariProgramId);
                cs.setInt(3, noviProgramId);
                int affectedRows = cs.executeUpdate();

                if (affectedRows > 0) {
                    conn.commit();
                    System.out.println("Polaznik je uspješno prebačen.");
                } else {
                    conn.rollback();
                    System.out.println("Prebacivanje neuspješno. Provjerite jesu li ID-jevi polaznika i starog programa ispravni.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Dogodila se SQL greška. Transakcija se poništava.");
            if (conn != null) try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
        } finally {
            if (conn != null) try { conn.setAutoCommit(true); conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public void ispisiPolaznike(int programId) {
        try (Connection conn = SQLDataSourceUtil.getSQLServerDataSource().getConnection();
             CallableStatement cs = conn.prepareCall(StoredProcedures.ISPISI_POLAZNIKE_NA_PROGRAMU)) {

            cs.setInt(1, programId);
            try (ResultSet rs = cs.executeQuery()) {
                System.out.println("\n--- Polaznici na odabranom programu ---");
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.printf(" - %s %s, Program: %s, CSVET bodovi: %d%n",
                            rs.getString("Ime"),
                            rs.getString("Prezime"),
                            rs.getString("Naziv"),
                            rs.getInt("CSVET"));
                }
                if (!found) {
                    System.out.println("Nema upisanih polaznika na odabranom programu.");
                }
                System.out.println("----------------------------------------\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}