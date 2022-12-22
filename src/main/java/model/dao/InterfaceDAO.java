package model.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;

import java.util.List;

public interface InterfaceDAO<T> {

    void insert(T t, SessionFactory factory);
    List<T> find(EntityManager entityManager);
    boolean delete(T t, SessionFactory factory);
    void update(T t, SessionFactory factory, String campoActualizar, String actualizado);

    T findById(Integer id, EntityManager entityManager);
}