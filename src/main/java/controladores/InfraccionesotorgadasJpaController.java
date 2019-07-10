/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.Infraccionesotorgadas;
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
public class InfraccionesotorgadasJpaController implements Serializable {

    public InfraccionesotorgadasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Infraccionesotorgadas infraccionesotorgadas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(infraccionesotorgadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Infraccionesotorgadas infraccionesotorgadas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            infraccionesotorgadas = em.merge(infraccionesotorgadas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = infraccionesotorgadas.getId();
                if (findInfraccionesotorgadas(id) == null) {
                    throw new NonexistentEntityException("The infraccionesotorgadas with id " + id + " no longer exists.");
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
            Infraccionesotorgadas infraccionesotorgadas;
            try {
                infraccionesotorgadas = em.getReference(Infraccionesotorgadas.class, id);
                infraccionesotorgadas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infraccionesotorgadas with id " + id + " no longer exists.", enfe);
            }
            em.remove(infraccionesotorgadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Infraccionesotorgadas> findInfraccionesotorgadasEntities() {
        return findInfraccionesotorgadasEntities(true, -1, -1);
    }

    public List<Infraccionesotorgadas> findInfraccionesotorgadasEntities(int maxResults, int firstResult) {
        return findInfraccionesotorgadasEntities(false, maxResults, firstResult);
    }

    private List<Infraccionesotorgadas> findInfraccionesotorgadasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Infraccionesotorgadas.class));
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

    public Infraccionesotorgadas findInfraccionesotorgadas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Infraccionesotorgadas.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfraccionesotorgadasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Infraccionesotorgadas> rt = cq.from(Infraccionesotorgadas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
