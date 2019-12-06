/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Empleados;
import entidades.Detallepagos;
import entidades.Pagos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class PagosJpaController implements Serializable {

    public PagosJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Pagos pagos) {
        if (pagos.getDetallepagosList() == null) {
            pagos.setDetallepagosList(new ArrayList<Detallepagos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empleadosId = pagos.getEmpleadosId();
            if (empleadosId != null) {
                empleadosId = em.getReference(empleadosId.getClass(), empleadosId.getId());
                pagos.setEmpleadosId(empleadosId);
            }
            List<Detallepagos> attachedDetallepagosList = new ArrayList<Detallepagos>();
            for (Detallepagos detallepagosListDetallepagosToAttach : pagos.getDetallepagosList()) {
                detallepagosListDetallepagosToAttach = em.getReference(detallepagosListDetallepagosToAttach.getClass(), detallepagosListDetallepagosToAttach.getId());
                attachedDetallepagosList.add(detallepagosListDetallepagosToAttach);
            }
            pagos.setDetallepagosList(attachedDetallepagosList);
            em.persist(pagos);
            if (empleadosId != null) {
                empleadosId.getPagosList().add(pagos);
                empleadosId = em.merge(empleadosId);
            }
            for (Detallepagos detallepagosListDetallepagos : pagos.getDetallepagosList()) {
                Pagos oldPagosIdOfDetallepagosListDetallepagos = detallepagosListDetallepagos.getPagosId();
                detallepagosListDetallepagos.setPagosId(pagos);
                detallepagosListDetallepagos = em.merge(detallepagosListDetallepagos);
                if (oldPagosIdOfDetallepagosListDetallepagos != null) {
                    oldPagosIdOfDetallepagosListDetallepagos.getDetallepagosList().remove(detallepagosListDetallepagos);
                    oldPagosIdOfDetallepagosListDetallepagos = em.merge(oldPagosIdOfDetallepagosListDetallepagos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pagos pagos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pagos persistentPagos = em.find(Pagos.class, pagos.getId());
            Empleados empleadosIdOld = persistentPagos.getEmpleadosId();
            Empleados empleadosIdNew = pagos.getEmpleadosId();
            List<Detallepagos> detallepagosListOld = persistentPagos.getDetallepagosList();
            List<Detallepagos> detallepagosListNew = pagos.getDetallepagosList();
            List<String> illegalOrphanMessages = null;
            for (Detallepagos detallepagosListOldDetallepagos : detallepagosListOld) {
                if (!detallepagosListNew.contains(detallepagosListOldDetallepagos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallepagos " + detallepagosListOldDetallepagos + " since its pagosId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (empleadosIdNew != null) {
                empleadosIdNew = em.getReference(empleadosIdNew.getClass(), empleadosIdNew.getId());
                pagos.setEmpleadosId(empleadosIdNew);
            }
            List<Detallepagos> attachedDetallepagosListNew = new ArrayList<Detallepagos>();
            for (Detallepagos detallepagosListNewDetallepagosToAttach : detallepagosListNew) {
                detallepagosListNewDetallepagosToAttach = em.getReference(detallepagosListNewDetallepagosToAttach.getClass(), detallepagosListNewDetallepagosToAttach.getId());
                attachedDetallepagosListNew.add(detallepagosListNewDetallepagosToAttach);
            }
            detallepagosListNew = attachedDetallepagosListNew;
            pagos.setDetallepagosList(detallepagosListNew);
            pagos = em.merge(pagos);
            if (empleadosIdOld != null && !empleadosIdOld.equals(empleadosIdNew)) {
                empleadosIdOld.getPagosList().remove(pagos);
                empleadosIdOld = em.merge(empleadosIdOld);
            }
            if (empleadosIdNew != null && !empleadosIdNew.equals(empleadosIdOld)) {
                empleadosIdNew.getPagosList().add(pagos);
                empleadosIdNew = em.merge(empleadosIdNew);
            }
            for (Detallepagos detallepagosListNewDetallepagos : detallepagosListNew) {
                if (!detallepagosListOld.contains(detallepagosListNewDetallepagos)) {
                    Pagos oldPagosIdOfDetallepagosListNewDetallepagos = detallepagosListNewDetallepagos.getPagosId();
                    detallepagosListNewDetallepagos.setPagosId(pagos);
                    detallepagosListNewDetallepagos = em.merge(detallepagosListNewDetallepagos);
                    if (oldPagosIdOfDetallepagosListNewDetallepagos != null && !oldPagosIdOfDetallepagosListNewDetallepagos.equals(pagos)) {
                        oldPagosIdOfDetallepagosListNewDetallepagos.getDetallepagosList().remove(detallepagosListNewDetallepagos);
                        oldPagosIdOfDetallepagosListNewDetallepagos = em.merge(oldPagosIdOfDetallepagosListNewDetallepagos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pagos.getId();
                if (findPagos(id) == null) {
                    throw new NonexistentEntityException("The pagos with id " + id + " no longer exists.");
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
            Pagos pagos;
            try {
                pagos = em.getReference(Pagos.class, id);
                pagos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pagos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Detallepagos> detallepagosListOrphanCheck = pagos.getDetallepagosList();
            for (Detallepagos detallepagosListOrphanCheckDetallepagos : detallepagosListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pagos (" + pagos + ") cannot be destroyed since the Detallepagos " + detallepagosListOrphanCheckDetallepagos + " in its detallepagosList field has a non-nullable pagosId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleados empleadosId = pagos.getEmpleadosId();
            if (empleadosId != null) {
                empleadosId.getPagosList().remove(pagos);
                empleadosId = em.merge(empleadosId);
            }
            em.remove(pagos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Acá se filtran los pagos efectuados a un empleado
    public List filtrar(Empleados idempleado)
    {
        Query query = emf.createNamedQuery("Pagos.filtradoFecha", Pagos.class);
        query.setParameter("idempleado", idempleado);
        return query.getResultList();
    }
    //Acá se obtiene un listado de pagos que se hicieron a un empleado, con una fecha de inicio y una de fin
    public List filtrarFecha(Date fecha1, Date fecha2, Empleados idempleado)
    {
        Query query = emf.createNamedQuery("Pagos.filtrado", Pagos.class);
        query.setParameter("fecha1", fecha1);
        query.setParameter("fecha2", fecha2);
        query.setParameter("idempleado", idempleado);
        return query.getResultList();
    }
    //Acá se obtiene un pago efectuado
    public List obtenerPago(Integer id)
    {
        Query query = emf.createNamedQuery("Pagos.findById", Pagos.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Pagos> findPagosEntities() {
        return findPagosEntities(true, -1, -1);
    }

    public List<Pagos> findPagosEntities(int maxResults, int firstResult) {
        return findPagosEntities(false, maxResults, firstResult);
    }

    private List<Pagos> findPagosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pagos.class));
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

    public Pagos findPagos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pagos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pagos> rt = cq.from(Pagos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
