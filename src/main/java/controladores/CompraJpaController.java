/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import entidades.Compra;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Compras;
import entidades.Detallecompras;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class CompraJpaController implements Serializable {

    public CompraJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Compra compra) {
        if (compra.getDetallecomprasList() == null) {
            compra.setDetallecomprasList(new ArrayList<Detallecompras>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compras comprasIdcompras = compra.getComprasIdcompras();
            if (comprasIdcompras != null) {
                comprasIdcompras = em.getReference(comprasIdcompras.getClass(), comprasIdcompras.getIdcompras());
                compra.setComprasIdcompras(comprasIdcompras);
            }
            List<Detallecompras> attachedDetallecomprasList = new ArrayList<Detallecompras>();
            for (Detallecompras detallecomprasListDetallecomprasToAttach : compra.getDetallecomprasList()) {
                detallecomprasListDetallecomprasToAttach = em.getReference(detallecomprasListDetallecomprasToAttach.getClass(), detallecomprasListDetallecomprasToAttach.getId());
                attachedDetallecomprasList.add(detallecomprasListDetallecomprasToAttach);
            }
            compra.setDetallecomprasList(attachedDetallecomprasList);
            em.persist(compra);
            if (comprasIdcompras != null) {
                comprasIdcompras.getCompraList().add(compra);
                comprasIdcompras = em.merge(comprasIdcompras);
            }
            for (Detallecompras detallecomprasListDetallecompras : compra.getDetallecomprasList()) {
                Compra oldCompraidOfDetallecomprasListDetallecompras = detallecomprasListDetallecompras.getCompraid();
                detallecomprasListDetallecompras.setCompraid(compra);
                detallecomprasListDetallecompras = em.merge(detallecomprasListDetallecompras);
                if (oldCompraidOfDetallecomprasListDetallecompras != null) {
                    oldCompraidOfDetallecomprasListDetallecompras.getDetallecomprasList().remove(detallecomprasListDetallecompras);
                    oldCompraidOfDetallecomprasListDetallecompras = em.merge(oldCompraidOfDetallecomprasListDetallecompras);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compra compra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getId());
            Compras comprasIdcomprasOld = persistentCompra.getComprasIdcompras();
            Compras comprasIdcomprasNew = compra.getComprasIdcompras();
            List<Detallecompras> detallecomprasListOld = persistentCompra.getDetallecomprasList();
            List<Detallecompras> detallecomprasListNew = compra.getDetallecomprasList();
            List<String> illegalOrphanMessages = null;
            for (Detallecompras detallecomprasListOldDetallecompras : detallecomprasListOld) {
                if (!detallecomprasListNew.contains(detallecomprasListOldDetallecompras)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallecompras " + detallecomprasListOldDetallecompras + " since its compraid field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (comprasIdcomprasNew != null) {
                comprasIdcomprasNew = em.getReference(comprasIdcomprasNew.getClass(), comprasIdcomprasNew.getIdcompras());
                compra.setComprasIdcompras(comprasIdcomprasNew);
            }
            List<Detallecompras> attachedDetallecomprasListNew = new ArrayList<Detallecompras>();
            for (Detallecompras detallecomprasListNewDetallecomprasToAttach : detallecomprasListNew) {
                detallecomprasListNewDetallecomprasToAttach = em.getReference(detallecomprasListNewDetallecomprasToAttach.getClass(), detallecomprasListNewDetallecomprasToAttach.getId());
                attachedDetallecomprasListNew.add(detallecomprasListNewDetallecomprasToAttach);
            }
            detallecomprasListNew = attachedDetallecomprasListNew;
            compra.setDetallecomprasList(detallecomprasListNew);
            compra = em.merge(compra);
            if (comprasIdcomprasOld != null && !comprasIdcomprasOld.equals(comprasIdcomprasNew)) {
                comprasIdcomprasOld.getCompraList().remove(compra);
                comprasIdcomprasOld = em.merge(comprasIdcomprasOld);
            }
            if (comprasIdcomprasNew != null && !comprasIdcomprasNew.equals(comprasIdcomprasOld)) {
                comprasIdcomprasNew.getCompraList().add(compra);
                comprasIdcomprasNew = em.merge(comprasIdcomprasNew);
            }
            for (Detallecompras detallecomprasListNewDetallecompras : detallecomprasListNew) {
                if (!detallecomprasListOld.contains(detallecomprasListNewDetallecompras)) {
                    Compra oldCompraidOfDetallecomprasListNewDetallecompras = detallecomprasListNewDetallecompras.getCompraid();
                    detallecomprasListNewDetallecompras.setCompraid(compra);
                    detallecomprasListNewDetallecompras = em.merge(detallecomprasListNewDetallecompras);
                    if (oldCompraidOfDetallecomprasListNewDetallecompras != null && !oldCompraidOfDetallecomprasListNewDetallecompras.equals(compra)) {
                        oldCompraidOfDetallecomprasListNewDetallecompras.getDetallecomprasList().remove(detallecomprasListNewDetallecompras);
                        oldCompraidOfDetallecomprasListNewDetallecompras = em.merge(oldCompraidOfDetallecomprasListNewDetallecompras);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compra.getId();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Detallecompras> detallecomprasListOrphanCheck = compra.getDetallecomprasList();
            for (Detallecompras detallecomprasListOrphanCheckDetallecompras : detallecomprasListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compra (" + compra + ") cannot be destroyed since the Detallecompras " + detallecomprasListOrphanCheckDetallecompras + " in its detallecomprasList field has a non-nullable compraid field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Compras comprasIdcompras = compra.getComprasIdcompras();
            if (comprasIdcompras != null) {
                comprasIdcompras.getCompraList().remove(compra);
                comprasIdcompras = em.merge(comprasIdcompras);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Se obtiene una compra realizada
    public List obtenerCompra(Integer id)
    {
        Query query = emf.createNamedQuery("Compra.findById", Compra.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
    //Se obtiene un listado de compras por medio de un rango de fechas (inicio y fin)
    public List filtrarFecha(Date fecha1, Date fecha2, Compras idcompra)
    {
        Query query = emf.createNamedQuery("Compra.filtrado", Compra.class);
        query.setParameter("fecha1", fecha1);
        query.setParameter("fecha2", fecha2);
        query.setParameter("idEmpresa", idcompra);
        return query.getResultList();
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
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

    public Compra findCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
