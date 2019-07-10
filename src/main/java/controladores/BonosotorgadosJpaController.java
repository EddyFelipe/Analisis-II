/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.Bonosotorgados;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author igeni
 */
public class BonosotorgadosJpaController implements Serializable {

    public BonosotorgadosJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Bonosotorgados bonosotorgados) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bonosotorgados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBonosotorgados(bonosotorgados.getId()) != null) {
                throw new PreexistingEntityException("Bonosotorgados " + bonosotorgados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bonosotorgados bonosotorgados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bonosotorgados = em.merge(bonosotorgados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bonosotorgados.getId();
                if (findBonosotorgados(id) == null) {
                    throw new NonexistentEntityException("The bonosotorgados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bonosotorgados bonosotorgados;
            try {
                bonosotorgados = em.getReference(Bonosotorgados.class, id);
                bonosotorgados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bonosotorgados with id " + id + " no longer exists.", enfe);
            }
            em.remove(bonosotorgados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bonosotorgados> findBonosotorgadosEntities() {
        return findBonosotorgadosEntities(true, -1, -1);
    }

    public List<Bonosotorgados> findBonosotorgadosEntities(int maxResults, int firstResult) {
        return findBonosotorgadosEntities(false, maxResults, firstResult);
    }

    private List<Bonosotorgados> findBonosotorgadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bonosotorgados.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Bonosotorgados findBonosotorgados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bonosotorgados.class, id);
        } finally {
            em.close();
        }
    }

    public int getBonosotorgadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bonosotorgados> rt = cq.from(Bonosotorgados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
