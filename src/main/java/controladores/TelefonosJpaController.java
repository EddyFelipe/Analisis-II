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
import entidades.Compras;
import entidades.Empleados;
import entidades.Telefonos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class TelefonosJpaController implements Serializable {

    public TelefonosJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Telefonos telefonos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compras comprasIdcompras = telefonos.getComprasIdcompras();
            if (comprasIdcompras != null) {
                comprasIdcompras = em.getReference(comprasIdcompras.getClass(), comprasIdcompras.getIdcompras());
                telefonos.setComprasIdcompras(comprasIdcompras);
            }
            Empleados empleadosId = telefonos.getEmpleadosId();
            if (empleadosId != null) {
                empleadosId = em.getReference(empleadosId.getClass(), empleadosId.getId());
                telefonos.setEmpleadosId(empleadosId);
            }
            em.persist(telefonos);
            if (comprasIdcompras != null) {
                comprasIdcompras.getTelefonosList().add(telefonos);
                comprasIdcompras = em.merge(comprasIdcompras);
            }
            if (empleadosId != null) {
                empleadosId.getTelefonosList().add(telefonos);
                empleadosId = em.merge(empleadosId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Telefonos telefonos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Telefonos persistentTelefonos = em.find(Telefonos.class, telefonos.getId());
            Compras comprasIdcomprasOld = persistentTelefonos.getComprasIdcompras();
            Compras comprasIdcomprasNew = telefonos.getComprasIdcompras();
            Empleados empleadosIdOld = persistentTelefonos.getEmpleadosId();
            Empleados empleadosIdNew = telefonos.getEmpleadosId();
            if (comprasIdcomprasNew != null) {
                comprasIdcomprasNew = em.getReference(comprasIdcomprasNew.getClass(), comprasIdcomprasNew.getIdcompras());
                telefonos.setComprasIdcompras(comprasIdcomprasNew);
            }
            if (empleadosIdNew != null) {
                empleadosIdNew = em.getReference(empleadosIdNew.getClass(), empleadosIdNew.getId());
                telefonos.setEmpleadosId(empleadosIdNew);
            }
            telefonos = em.merge(telefonos);
            if (comprasIdcomprasOld != null && !comprasIdcomprasOld.equals(comprasIdcomprasNew)) {
                comprasIdcomprasOld.getTelefonosList().remove(telefonos);
                comprasIdcomprasOld = em.merge(comprasIdcomprasOld);
            }
            if (comprasIdcomprasNew != null && !comprasIdcomprasNew.equals(comprasIdcomprasOld)) {
                comprasIdcomprasNew.getTelefonosList().add(telefonos);
                comprasIdcomprasNew = em.merge(comprasIdcomprasNew);
            }
            if (empleadosIdOld != null && !empleadosIdOld.equals(empleadosIdNew)) {
                empleadosIdOld.getTelefonosList().remove(telefonos);
                empleadosIdOld = em.merge(empleadosIdOld);
            }
            if (empleadosIdNew != null && !empleadosIdNew.equals(empleadosIdOld)) {
                empleadosIdNew.getTelefonosList().add(telefonos);
                empleadosIdNew = em.merge(empleadosIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = telefonos.getId();
                if (findTelefonos(id) == null) {
                    throw new NonexistentEntityException("The telefonos with id " + id + " no longer exists.");
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
            Telefonos telefonos;
            try {
                telefonos = em.getReference(Telefonos.class, id);
                telefonos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The telefonos with id " + id + " no longer exists.", enfe);
            }
            Compras comprasIdcompras = telefonos.getComprasIdcompras();
            if (comprasIdcompras != null) {
                comprasIdcompras.getTelefonosList().remove(telefonos);
                comprasIdcompras = em.merge(comprasIdcompras);
            }
            Empleados empleadosId = telefonos.getEmpleadosId();
            if (empleadosId != null) {
                empleadosId.getTelefonosList().remove(telefonos);
                empleadosId = em.merge(empleadosId);
            }
            em.remove(telefonos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Acá se obtiene un número en específico, para validar que no se ingresen dos números iguales
    public List encontrarTelefono(String numero)
    {
        Query query = emf.createNamedQuery("Telefonos.findByNumero", Telefonos.class);
        query.setParameter("numero", numero);
        return query.getResultList();
    }
    //Acá se obtiene un listado de teléfonos de un empleado en específico
    public List desplegarTelefonos(Empleados empleado)
    {
        Query query = emf.createNamedQuery("Telefonos.encontrar", Telefonos.class);
        query.setParameter("empleadoId", empleado);
        return query.getResultList();
    }
    //Acá se obtiene un listado de teléfonos de una empresa en específico
    public List desplegarTelefonosEmpresa(Compras empresa)
    {
        Query query = emf.createNamedQuery("Telefonos.encontrarEmpresa", Telefonos.class);
        query.setParameter("idCompras", empresa);
        return query.getResultList();
    }
    //Acá se filtran los teléfonos de un empleado en específico, por medio de una consulta de MySQL
    public List filtrar(String telefono, Empleados empleado)
    {
        Query query = emf.createNamedQuery("Telefonos.filtring", Telefonos.class);
        query.setParameter("numempleado", telefono + "%");
        query.setParameter("empleadoId", empleado);
        return query.getResultList();
    }
    //Acá se filtran los teléfonos de una empresa en específico, por medio de una consulta de MySQL
    public List filtrarEmpresa(String telefono, Compras empresa)
    {
        Query query = emf.createNamedQuery("Telefonos.filtrar", Telefonos.class);
        query.setParameter("numempresa", telefono + "%");
        query.setParameter("idCompras", empresa);
        return query.getResultList();
    }

    public List<Telefonos> findTelefonosEntities() {
        return findTelefonosEntities(true, -1, -1);
    }

    public List<Telefonos> findTelefonosEntities(int maxResults, int firstResult) {
        return findTelefonosEntities(false, maxResults, firstResult);
    }

    private List<Telefonos> findTelefonosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Telefonos.class));
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

    public Telefonos findTelefonos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Telefonos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTelefonosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Telefonos> rt = cq.from(Telefonos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
