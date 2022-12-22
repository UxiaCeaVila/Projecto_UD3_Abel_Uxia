package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Especies;
import model.entities.Planeta;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class EspeciesDAO implements InterfaceDAO<Especies> {
    @Override
    public void insert(Especies especies, SessionFactory factory) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(especies);
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
    public List<Especies> find(EntityManager entityManager) {

        Query select = entityManager.createQuery("select especies from Especies especies");
        Especies especies  = new Especies();
        List<Especies> especiesList = select.getResultList();
        return especiesList;
    }

    @Override
    public boolean delete(Especies especies, SessionFactory factory) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(especies);
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
    public void update(Especies especies, SessionFactory factory, String campoActualizar, String actualizado) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if(campoActualizar == "nombre"){
                especies.setNombre(actualizado);
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
                especies.setPlanetaOrigen(planeta);
            } else if (campoActualizar == "fisiologia") {
                especies.setFisiologia(Integer.parseInt(actualizado));
            }
            session.update(especies);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public Especies findById(Integer id, EntityManager entityManager) {

        Query select = entityManager.createQuery("select especies from Especies especies where Especies.id = "+id);
        Especies especies  = new Especies();
        Especies especie =(Especies) select.getSingleResult();
        return especie;
    }
}
