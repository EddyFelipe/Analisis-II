/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.BonosDescuentos;
import entidades.Detallepagos;
import entidades.Pagos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class DetallepagosJpaController implements Serializable {

    public DetallepagosJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Detallepagos detallepagos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BonosDescuentos bonosDescuentosId = detallepagos.getBonosDescuentosId();
            if (bonosDescuentosId != null) {
                bonosDescuentosId = em.getReference(bonosDescuentosId.getClass(), bonosDescuentosId.getId());
                detallepagos.setBonosDescuentosId(bonosDescuentosId);
            }
            Pagos pagosId = detallepagos.getPagosId();
            if (pagosId != null) {
                pagosId = em.getReference(pagosId.getClass(), pagosId.getId());
                detallepagos.setPagosId(pagosId);
            }
            em.persist(detallepagos);
            if (bonosDescuentosId != null) {
                bonosDescuentosId.getDetallepagosList().add(detallepagos);
                bonosDescuentosId = em.merge(bonosDescuentosId);
            }
            if (pagosId != null) {
                pagosId.getDetallepagosList().add(detallepagos);
                pagosId = em.merge(pagosId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detallepagos detallepagos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallepagos persistentDetallepagos = em.find(Detallepagos.class, detallepagos.getId());
            BonosDescuentos bonosDescuentosIdOld = persistentDetallepagos.getBonosDescuentosId();
            BonosDescuentos bonosDescuentosIdNew = detallepagos.getBonosDescuentosId();
            Pagos pagosIdOld = persistentDetallepagos.getPagosId();
            Pagos pagosIdNew = detallepagos.getPagosId();
            if (bonosDescuentosIdNew != null) {
                bonosDescuentosIdNew = em.getReference(bonosDescuentosIdNew.getClass(), bonosDescuentosIdNew.getId());
                detallepagos.setBonosDescuentosId(bonosDescuentosIdNew);
            }
            if (pagosIdNew != null) {
                pagosIdNew = em.getReference(pagosIdNew.getClass(), pagosIdNew.getId());
                detallepagos.setPagosId(pagosIdNew);
            }
            detallepagos = em.merge(detallepagos);
            if (bonosDescuentosIdOld != null && !bonosDescuentosIdOld.equals(bonosDescuentosIdNew)) {
                bonosDescuentosIdOld.getDetallepagosList().remove(detallepagos);
                bonosDescuentosIdOld = em.merge(bonosDescuentosIdOld);
            }
            if (bonosDescuentosIdNew != null && !bonosDescuentosIdNew.equals(bonosDescuentosIdOld)) {
                bonosDescuentosIdNew.getDetallepagosList().add(detallepagos);
                bonosDescuentosIdNew = em.merge(bonosDescuentosIdNew);
            }
            if (pagosIdOld != null && !pagosIdOld.equals(pagosIdNew)) {
                pagosIdOld.getDetallepagosList().remove(detallepagos);
                pagosIdOld = em.merge(pagosIdOld);
            }
            if (pagosIdNew != null && !pagosIdNew.equals(pagosIdOld)) {
                pagosIdNew.getDetallepagosList().add(detallepagos);
                pagosIdNew = em.merge(pagosIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detallepagos.getId();
                if (findDetallepagos(id) == null) {
                    throw new NonexistentEntityException("The detallepagos with id " + id + " no longer exists.");
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
            Detallepagos detallepagos;
            try {
                detallepagos = em.getReference(Detallepagos.class, id);
                detallepagos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallepagos with id " + id + " no longer exists.", enfe);
            }
            BonosDescuentos bonosDescuentosId = detallepagos.getBonosDescuentosId();
            if (bonosDescuentosId != null) {
                bonosDescuentosId.getDetallepagosList().remove(detallepagos);
                bonosDescuentosId = em.merge(bonosDescuentosId);
            }
            Pagos pagosId = detallepagos.getPagosId();
            if (pagosId != null) {
                pagosId.getDetallepagosList().remove(detallepagos);
                pagosId = em.merge(pagosId);
            }
            em.remove(detallepagos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    //Se obtiene un listado de detalles de pago
    public List<Detallepagos> listadoDetalles(Pagos pago)
    {
        Query query = emf.createNamedQuery("Detallepagos.listado", Detallepagos.class);
        query.setParameter("pagosId", pago);
        return query.getResultList();
    }

    public List<Detallepagos> findDetallepagosEntities() {
        return findDetallepagosEntities(true, -1, -1);
    }

    public List<Detallepagos> findDetallepagosEntities(int maxResults, int firstResult) {
        return findDetallepagosEntities(false, maxResults, firstResult);
    }

    private List<Detallepagos> findDetallepagosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detallepagos.class));
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

    public Detallepagos findDetallepagos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detallepagos.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallepagosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detallepagos> rt = cq.from(Detallepagos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
