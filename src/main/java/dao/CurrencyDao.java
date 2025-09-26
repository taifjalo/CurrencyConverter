package dao;

import entity.Currency;
import jakarta.persistence.EntityManager;

import java.util.List;


public class CurrencyDao {


    public void addOne(Currency currency) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(currency);   // INSERT INTO employee ...
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
             em.close(); // we do not close the connection because it is a singleton
        }

    }

    public List<Currency> findAll() {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            return em.createQuery("select e from Currency e", Currency.class).getResultList();  // SELECT * FROM employe
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close(); // we do not close the connection because it is a singleton
}
    }

    public Currency findOne(String abbreviation) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        try {
            return em.find(Currency.class, abbreviation); // SELECT * FROM employee WHERE abbreviation (id) = ?
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close(); // we do not close the connection because it is a singleton
        }
    }
}
