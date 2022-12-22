package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Magia;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MagiasDAO implements InterfaceDAO<Magia>{
    @Override
    public void insert(Magia magia, SessionFactory factory) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(magia);
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
    public List<Magia> find(EntityManager entityManager) {

        Query select = entityManager.createQuery("select magia from Magia magia");
        Magia magia  = new Magia();
        List<Magia> magiasList = select.getResultList();
        return magiasList;
    }

    @Override
    public boolean delete(Magia magia, SessionFactory factory) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(magia);
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
    public void update(Magia magia, SessionFactory factory, String campoActualizar, String actualizado) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if(campoActualizar == "nombre"){
                magia.setNombre(actualizado);
            } else if (campoActualizar == "descripcion") {
                magia.setDescripcion(actualizado);
            } else if (campoActualizar == "esquirla") {
                magia.setEsquirla(actualizado);
            }
            session.update(magia);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Magia findById(Integer id, EntityManager entityManager) {

        Query select = entityManager.createQuery("select magia from Magia magia where Magia.id = "+id);
        Magia magia  = new Magia();
        Magia magias = (Magia) select.getSingleResult();
        return magias;
    }
}
