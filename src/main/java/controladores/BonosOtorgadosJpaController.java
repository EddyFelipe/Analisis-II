/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import entidades.BonosOtorgados;
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
 * @author felipe
 */
public class BonosOtorgadosJpaController implements Serializable {

    public BonosOtorgadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BonosOtorgados bonosOtorgados) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bonosOtorgados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBonosOtorgados(bonosOtorgados.getId()) != null) {
                throw new PreexistingEntityException("BonosOtorgados " + bonosOtorgados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BonosOtorgados bonosOtorgados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bonosOtorgados = em.merge(bonosOtorgados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bonosOtorgados.getId();
                if (findBonosOtorgados(id) == null) {
                    throw new NonexistentEntityException("The bonosOtorgados with id " + id + " no longer exists.");
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
            BonosOtorgados bonosOtorgados;
            try {
                bonosOtorgados = em.getReference(BonosOtorgados.class, id);
                bonosOtorgados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bonosOtorgados with id " + id + " no longer exists.", enfe);
            }
            em.remove(bonosOtorgados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BonosOtorgados> findBonosOtorgadosEntities() {
        return findBonosOtorgadosEntities(true, -1, -1);
    }

    public List<BonosOtorgados> findBonosOtorgadosEntities(int maxResults, int firstResult) {
        return findBonosOtorgadosEntities(false, maxResults, firstResult);
    }

    private List<BonosOtorgados> findBonosOtorgadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BonosOtorgados.class));
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

    public BonosOtorgados findBonosOtorgados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BonosOtorgados.class, id);
        } finally {
            em.close();
        }
    }

    public int getBonosOtorgadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BonosOtorgados> rt = cq.from(BonosOtorgados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
