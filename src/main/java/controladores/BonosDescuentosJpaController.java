/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.BonosDescuentos;
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
 * @author User
 */
public class BonosDescuentosJpaController implements Serializable {

    public BonosDescuentosJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(BonosDescuentos bonosDescuentos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bonosDescuentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BonosDescuentos bonosDescuentos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bonosDescuentos = em.merge(bonosDescuentos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bonosDescuentos.getId();
                if (findBonosDescuentos(id) == null) {
                    throw new NonexistentEntityException("The bonosDescuentos with id " + id + " no longer exists.");
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
            BonosDescuentos bonosDescuentos;
            try {
                bonosDescuentos = em.getReference(BonosDescuentos.class, id);
                bonosDescuentos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bonosDescuentos with id " + id + " no longer exists.", enfe);
            }
            em.remove(bonosDescuentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List encontrarBono_Descuento(String bono_descuento)
    {
        Query query = emf.createNamedQuery("BonosDescuentos.findByDescripci\u00f3n", BonosDescuentos.class);
        query.setParameter("descripci\u00f3n", bono_descuento);
        return query.getResultList();
    }
    
    public List filtrar(String bono_descuento)
    {
        Query query = emf.createNamedQuery("BonosDescuentos.filtring", BonosDescuentos.class);
        query.setParameter("descripcion", bono_descuento + "%");
        return query.getResultList();
    }

    public List<BonosDescuentos> findBonosDescuentosEntities() {
        return findBonosDescuentosEntities(true, -1, -1);
    }

    public List<BonosDescuentos> findBonosDescuentosEntities(int maxResults, int firstResult) {
        return findBonosDescuentosEntities(false, maxResults, firstResult);
    }

    private List<BonosDescuentos> findBonosDescuentosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BonosDescuentos.class));
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

    public BonosDescuentos findBonosDescuentos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BonosDescuentos.class, id);
        } finally {
            em.close();
        }
    }

    public int getBonosDescuentosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BonosDescuentos> rt = cq.from(BonosDescuentos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
