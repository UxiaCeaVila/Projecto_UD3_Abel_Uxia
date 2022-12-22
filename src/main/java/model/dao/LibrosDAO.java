package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Libro;
import model.entities.Planeta;
import model.entities.Sagas;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class LibrosDAO implements InterfaceDAO<Libro>{
    @Override
    public void insert(Libro libro, SessionFactory factory) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(libro);
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
    public List<Libro> find(EntityManager entityManager) {

        Query select = entityManager.createQuery("select libros from Libro libros");
        Libro libros  = new Libro();
        List<Libro> librosList = select.getResultList();
        return librosList;
    }

    @Override
    public boolean delete(Libro libro, SessionFactory factory) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(libro);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Libro libro, SessionFactory factory, String campoActualizar, String actualizado) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if(campoActualizar == "nombre"){
                libro.setNombre(actualizado);
            } else if (campoActualizar == "planeta") {
                Query selectPlaneta = factory.createEntityManager().createQuery("select planeta from Planeta planeta where Planeta.id = "+Integer.parseInt(actualizado));
                Planeta planeta = new Planeta();
                List lista = selectPlaneta.getResultList();
                for(Iterator iterator = lista.iterator(); iterator.hasNext();){
                    Planeta planeta1 = (Planeta) iterator.next();
                    planeta.setId(planeta1.getId());
                    planeta.setEsquirla(planeta1.getEsquirla());
                    planeta.setNombre(planeta1.getNombre());
                    planeta.setSistema(planeta1.getSistema());
                }
                libro.setPlaneta(planeta);
            } else if (campoActualizar == "saga") {
                Query selectSaga = factory.createEntityManager().createQuery("select saga from Sagas saga where Sagas.id = "+Integer.parseInt(actualizado));
                Sagas saga = new Sagas();
                List lista = selectSaga.getResultList();
                for(Iterator iterator = lista.iterator(); iterator.hasNext();){
                    Sagas sagas = (Sagas) iterator.next();
                    saga.setId(sagas.getId());
                    saga.setLongitud(sagas.getLongitud());
                    saga.setNombre(sagas.getNombre());
                    saga.setPlaneta(sagas.getPlaneta());
                }
                libro.setSaga(saga);
            }
            session.update(libro);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Libro findById(Integer id, EntityManager entityManager) {

        Query select = entityManager.createQuery("select libros from Libro libros where Libro.id = "+id);
        Libro libros  = new Libro();
        Libro libro = (Libro) select.getSingleResult();
        return libro;
    }
}
