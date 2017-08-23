/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Milan Skaric
 */
public class DB {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("BigProjectPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void insert(Object ... obj) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            for(Object o:obj)
               em.persist(o);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static void update(Object obj) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static void delete(Object obj) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static List query(String query, Object ... params) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q=em.createQuery(query);
            for(int i=0; i<params.length; i++)
                q.setParameter(i+1, params[i]);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }
    
    public static List query(String query, Map<String,Object> params) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q=em.createQuery(query);
            for(Entry<String,Object> e:params.entrySet()) {
                q.setParameter(e.getKey(), e.getValue());
            }
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }
    
    public static List namedQuery(String name) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q=em.createNamedQuery(name);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
    }
    
    
}
