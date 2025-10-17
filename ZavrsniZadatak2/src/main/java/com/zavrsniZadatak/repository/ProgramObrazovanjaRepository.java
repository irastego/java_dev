package com.zavrsniZadatak.repository;

import com.zavrsniZadatak.entity.ProgramObrazovanja;
import com.zavrsniZadatak.entity.Upis;
import com.zavrsniZadatak.repository.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Collections;
import java.util.List;

public class ProgramObrazovanjaRepository {

    public void dodaj(ProgramObrazovanja po) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(po);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<ProgramObrazovanja> dohvati() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM ProgramObrazovanja", ProgramObrazovanja.class).list();
        }
    }

    public void upisi(Upis upis) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(upis);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public ProgramObrazovanja dohvatiPoId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ProgramObrazovanja.class, id);
        }
    }

    public void prebaciPolaznika(int polaznikId, int stariProgramId, int noviProgramId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ProgramObrazovanja noviProgram = session.get(ProgramObrazovanja.class, noviProgramId);
            if (noviProgram == null) {
                System.out.println("Novi program ne postoji.");
                transaction.rollback();
                return;
            }

            String hql = "FROM Upis WHERE polaznik.id = :polaznikId AND programObrazovanja.id = :stariProgramId";
            Upis upisZaPromjenu = session.createQuery(hql, Upis.class)
                    .setParameter("polaznikId", polaznikId)
                    .setParameter("stariProgramId", stariProgramId)
                    .uniqueResult();

            if (upisZaPromjenu != null) {
                upisZaPromjenu.setProgramObrazovanja(noviProgram);
                session.merge(upisZaPromjenu);
                System.out.println("Polaznik uspješno prebačen.");
            } else {
                System.out.println("Polaznik nije pronađen na starom programu.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Upis> dohvatiUpiseZaProgram(int programId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Upis u JOIN FETCH u.polaznik JOIN FETCH u.programObrazovanja WHERE u.programObrazovanja.id = :programId";
            return session.createQuery(hql, Upis.class)
                    .setParameter("programId", programId)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}