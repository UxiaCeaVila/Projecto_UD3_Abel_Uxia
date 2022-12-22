package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Planeta;
import model.entities.Sagas;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class SagasDAO implements InterfaceDAO<Sagas>{
    @Override
    public void insert(Sagas sagas, SessionFactory factory) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(sagas);
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
    public List<Sagas> find(EntityManager entityManager) {

        Query select = entityManager.createQuery("select saga from Sagas saga");
        Sagas saga  = new Sagas();
        List<Sagas> sagasList = select.getResultList();
        return sagasList;
    }

    @Override
    public boolean delete(Sagas sagas, SessionFactory factory) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(sagas);
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
    public void update(Sagas sagas, SessionFactory factory, String campoActualizar, String actualizado) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if(campoActualizar == "nombre"){
                sagas.setNombre(actualizado);
            } else if (campoActualizar == "planeta") {

                Query selectPlaneta = factory.createEntityManager().createQuery("select especies from Especies especies where Especies.id = "+Integer.parseInt(actualizado));
                Planeta planeta = new Planeta();
                List lista = selectPlaneta.getResultList();
                for(Iterator iterator = lista.iterator(); iterator.hasNext();){
                    Planeta planeta1 = (Planeta) iterator.next();
                    planeta.setId(planeta1.getId());
                    planeta.setEsquirla(planeta1.getEsquirla());
                    planeta.setNombre(planeta1.getNombre());
                    planeta.setSistema(planeta1.getSistema());
                }
                sagas.setPlaneta(planeta);
            } else if (campoActualizar == "saga") {
                sagas.setLongitud(actualizado);
            }
            session.update(sagas);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Sagas findById(Integer id, EntityManager entityManager) {

        Query select = entityManager.createQuery("select saga from Sagas saga where Sagas.id = "+id);
        Sagas saga  = new Sagas();
        Sagas sagas = (Sagas) select.getResultList();
        return sagas;
    }
}
