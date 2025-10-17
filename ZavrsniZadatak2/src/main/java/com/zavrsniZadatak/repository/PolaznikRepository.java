package com.zavrsniZadatak.repository;

import com.zavrsniZadatak.entity.Polaznik;
import com.zavrsniZadatak.repository.constants.StoredProcedures;
import com.zavrsniZadatak.repository.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PolaznikRepository {
    public void dodaj(Polaznik polaznik) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(polaznik);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<Polaznik> dohvati() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Polaznik", Polaznik.class).list();
        }
    }

    public Polaznik dohvatiPoId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Polaznik.class, id);
        }
    }

}
