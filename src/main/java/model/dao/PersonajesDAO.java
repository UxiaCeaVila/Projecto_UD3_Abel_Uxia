package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.entities.Especies;
import model.entities.Personaje;
import model.entities.Planeta;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class PersonajesDAO implements InterfaceDAO<Personaje>{
    @Override
    public void insert(Personaje personaje, SessionFactory factory) {


        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(personaje);
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
    public List<Personaje> find(EntityManager entityManager) {

        Query select = entityManager.createQuery("select personaje from Personaje personaje");
        Personaje personaje  = new Personaje();
        List<Personaje> personajesList = select.getResultList();
        return personajesList;
    }

    @Override
    public boolean delete(Personaje personaje, SessionFactory factory) {

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(personaje);
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
    public void update(Personaje personaje, SessionFactory factory, String campoActualizar, String actualizado) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            if(campoActualizar == "nombre"){
                personaje.setNombre(actualizado);
            } else if (campoActualizar == "edad") {
                personaje.setEdad(actualizado);
            } else if (campoActualizar == "planeta_origen") {
                Query selectPlaneta = factory.createEntityManager().createQuery("select planeta from Planeta planeta where Planeta.id = " + Integer.parseInt(actualizado));
                Planeta planeta = new Planeta();
                List lista = selectPlaneta.getResultList();
                for (Iterator iterator = lista.iterator(); iterator.hasNext(); ) {
                    Planeta planeta1 = (Planeta) iterator.next();
                    planeta.setId(planeta1.getId());
                    planeta.setEsquirla(planeta1.getEsquirla());
                    planeta.setNombre(planeta1.getNombre());
                    planeta.setSistema(planeta1.getSistema());
                }
                personaje.setPlanetaOrigen(planeta);
            }else if (campoActualizar == "especie") {
                Query selectEspecie = factory.createEntityManager().createQuery("select especies from Especies especies where Especies.id = "+Integer.parseInt(actualizado));
                Especies especies = new Especies();
                List lista = selectEspecie.getResultList();
                for(Iterator iterator = lista.iterator(); iterator.hasNext();){
                    Especies especies1 = (Especies) iterator.next();
                    especies.setId(especies1.getId());
                    especies.setFisiologia(especies1.getFisiologia());
                    especies.setNombre(especies1.getNombre());
                    especies.setPlanetaOrigen(especies1.getPlanetaOrigen());
                }
                personaje.setEspecie(especies);
            }
            session.update(personaje);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Personaje findById(Integer id, EntityManager entityManager) {

        Query select = entityManager.createQuery("select personaje from Personaje personaje where Personaje.id = "+id);
        Personaje personaje  = new Personaje();
        Personaje personajes = (Personaje)select.getResultList();
        return personajes;
    }
}
