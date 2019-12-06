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
import entidades.Compra;
import entidades.Detallecompras;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class DetallecomprasJpaController implements Serializable {

    public DetallecomprasJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Detallecompras detallecompras) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra compraid = detallecompras.getCompraid();
            if (compraid != null) {
                compraid = em.getReference(compraid.getClass(), compraid.getId());
                detallecompras.setCompraid(compraid);
            }
            em.persist(detallecompras);
            if (compraid != null) {
                compraid.getDetallecomprasList().add(detallecompras);
                compraid = em.merge(compraid);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detallecompras detallecompras) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallecompras persistentDetallecompras = em.find(Detallecompras.class, detallecompras.getId());
            Compra compraidOld = persistentDetallecompras.getCompraid();
            Compra compraidNew = detallecompras.getCompraid();
            if (compraidNew != null) {
                compraidNew = em.getReference(compraidNew.getClass(), compraidNew.getId());
                detallecompras.setCompraid(compraidNew);
            }
            detallecompras = em.merge(detallecompras);
            if (compraidOld != null && !compraidOld.equals(compraidNew)) {
                compraidOld.getDetallecomprasList().remove(detallecompras);
                compraidOld = em.merge(compraidOld);
            }
            if (compraidNew != null && !compraidNew.equals(compraidOld)) {
                compraidNew.getDetallecomprasList().add(detallecompras);
                compraidNew = em.merge(compraidNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detallecompras.getId();
                if (findDetallecompras(id) == null) {
                    throw new NonexistentEntityException("The detallecompras with id " + id + " no longer exists.");
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
            Detallecompras detallecompras;
            try {
                detallecompras = em.getReference(Detallecompras.class, id);
                detallecompras.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallecompras with id " + id + " no longer exists.", enfe);
            }
            Compra compraid = detallecompras.getCompraid();
            if (compraid != null) {
                compraid.getDetallecomprasList().remove(detallecompras);
                compraid = em.merge(compraid);
            }
            em.remove(detallecompras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Se obtiene un listado de detalles de una compra
    public List<Detallecompras> listadoDetalles(Compra compra)
    {
        Query query = emf.createNamedQuery("Detallecompras.listado", Detallecompras.class);
        query.setParameter("idcompra", compra);
        return query.getResultList();
    }
    //Se elimina un detalle de compra
    public void eliminarDetalles(Compra compra)
    {
        Query query = emf.createNamedQuery("Detallecompras.eliminarDetalles", Detallecompras.class);
        query.setParameter("idcompra", compra);
    }
    //Se obtiene una compra efectuada
    public List obtenerCompra(Integer id)
    {
        Query query = emf.createNamedQuery("Detallecompras.findById", Compra.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Detallecompras> findDetallecomprasEntities() {
        return findDetallecomprasEntities(true, -1, -1);
    }

    public List<Detallecompras> findDetallecomprasEntities(int maxResults, int firstResult) {
        return findDetallecomprasEntities(false, maxResults, firstResult);
    }

    private List<Detallecompras> findDetallecomprasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detallecompras.class));
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

    public Detallecompras findDetallecompras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detallecompras.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallecomprasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detallecompras> rt = cq.from(Detallecompras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
