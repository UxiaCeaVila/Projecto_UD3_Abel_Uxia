package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Planeta;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetasDAO implements InterfaceDAO<Planeta>{

    @Override
    public void insert(Planeta planeta, SessionFactory factory) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(planeta);
            tx.commit();
            System.out.println("Libro insertado");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Planeta> find(EntityManager entityManager) {

        Query select = entityManager.createQuery("select planeta from Planeta planeta");
        Planeta planeta  = new Planeta();
        List<Planeta> planetaList = select.getResultList();
        return planetaList;
    }

    @Override
    public boolean delete(Planeta planeta, SessionFactory factory) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(planeta);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Planeta planeta, SessionFactory factory, String campoActualizar, String actualizado) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if(campoActualizar == "nombre"){
                planeta.setNombre(actualizado);
            } else if (campoActualizar == "sistema") {
                planeta.setSistema(actualizado);
            } else if (campoActualizar == "esquirla") {
                planeta.setEsquirla(actualizado);
            }
            session.update(planeta);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Planeta findById(Integer id, EntityManager entityManager) {

        Query select = entityManager.createQuery("select planetas from Planeta planetas where Planeta .id = "+id);
        Planeta planetas  = new Planeta();
        Planeta planeta = (Planeta) select.getSingleResult();
        return planeta;
    }
}
