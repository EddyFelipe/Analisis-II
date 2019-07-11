/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.InfraccionesOtorgadas;
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
public class InfraccionesOtorgadasJpaController implements Serializable {

    public InfraccionesOtorgadasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InfraccionesOtorgadas infraccionesOtorgadas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(infraccionesOtorgadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InfraccionesOtorgadas infraccionesOtorgadas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            infraccionesOtorgadas = em.merge(infraccionesOtorgadas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = infraccionesOtorgadas.getId();
                if (findInfraccionesOtorgadas(id) == null) {
                    throw new NonexistentEntityException("The infraccionesOtorgadas with id " + id + " no longer exists.");
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
            InfraccionesOtorgadas infraccionesOtorgadas;
            try {
                infraccionesOtorgadas = em.getReference(InfraccionesOtorgadas.class, id);
                infraccionesOtorgadas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The infraccionesOtorgadas with id " + id + " no longer exists.", enfe);
            }
            em.remove(infraccionesOtorgadas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InfraccionesOtorgadas> findInfraccionesOtorgadasEntities() {
        return findInfraccionesOtorgadasEntities(true, -1, -1);
    }

    public List<InfraccionesOtorgadas> findInfraccionesOtorgadasEntities(int maxResults, int firstResult) {
        return findInfraccionesOtorgadasEntities(false, maxResults, firstResult);
    }

    private List<InfraccionesOtorgadas> findInfraccionesOtorgadasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InfraccionesOtorgadas.class));
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

    public InfraccionesOtorgadas findInfraccionesOtorgadas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InfraccionesOtorgadas.class, id);
        } finally {
            em.close();
        }
    }

    public int getInfraccionesOtorgadasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InfraccionesOtorgadas> rt = cq.from(InfraccionesOtorgadas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
