/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import entidades.Empleados;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Telefonos;
import java.util.ArrayList;
import java.util.List;
import entidades.Pagos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class EmpleadosJpaController implements Serializable {

    public EmpleadosJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Empleados empleados) {
        if (empleados.getTelefonosList() == null) {
            empleados.setTelefonosList(new ArrayList<Telefonos>());
        }
        if (empleados.getPagosList() == null) {
            empleados.setPagosList(new ArrayList<Pagos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Telefonos> attachedTelefonosList = new ArrayList<Telefonos>();
            for (Telefonos telefonosListTelefonosToAttach : empleados.getTelefonosList()) {
                telefonosListTelefonosToAttach = em.getReference(telefonosListTelefonosToAttach.getClass(), telefonosListTelefonosToAttach.getId());
                attachedTelefonosList.add(telefonosListTelefonosToAttach);
            }
            empleados.setTelefonosList(attachedTelefonosList);
            List<Pagos> attachedPagosList = new ArrayList<Pagos>();
            for (Pagos pagosListPagosToAttach : empleados.getPagosList()) {
                pagosListPagosToAttach = em.getReference(pagosListPagosToAttach.getClass(), pagosListPagosToAttach.getId());
                attachedPagosList.add(pagosListPagosToAttach);
            }
            empleados.setPagosList(attachedPagosList);
            em.persist(empleados);
            for (Telefonos telefonosListTelefonos : empleados.getTelefonosList()) {
                Empleados oldEmpleadosIdOfTelefonosListTelefonos = telefonosListTelefonos.getEmpleadosId();
                telefonosListTelefonos.setEmpleadosId(empleados);
                telefonosListTelefonos = em.merge(telefonosListTelefonos);
                if (oldEmpleadosIdOfTelefonosListTelefonos != null) {
                    oldEmpleadosIdOfTelefonosListTelefonos.getTelefonosList().remove(telefonosListTelefonos);
                    oldEmpleadosIdOfTelefonosListTelefonos = em.merge(oldEmpleadosIdOfTelefonosListTelefonos);
                }
            }
            for (Pagos pagosListPagos : empleados.getPagosList()) {
                Empleados oldEmpleadosIdOfPagosListPagos = pagosListPagos.getEmpleadosId();
                pagosListPagos.setEmpleadosId(empleados);
                pagosListPagos = em.merge(pagosListPagos);
                if (oldEmpleadosIdOfPagosListPagos != null) {
                    oldEmpleadosIdOfPagosListPagos.getPagosList().remove(pagosListPagos);
                    oldEmpleadosIdOfPagosListPagos = em.merge(oldEmpleadosIdOfPagosListPagos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleados empleados) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados persistentEmpleados = em.find(Empleados.class, empleados.getId());
            List<Telefonos> telefonosListOld = persistentEmpleados.getTelefonosList();
            List<Telefonos> telefonosListNew = empleados.getTelefonosList();
            List<Pagos> pagosListOld = persistentEmpleados.getPagosList();
            List<Pagos> pagosListNew = empleados.getPagosList();
            List<String> illegalOrphanMessages = null;
            for (Pagos pagosListOldPagos : pagosListOld) {
                if (!pagosListNew.contains(pagosListOldPagos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pagos " + pagosListOldPagos + " since its empleadosId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Telefonos> attachedTelefonosListNew = new ArrayList<Telefonos>();
            for (Telefonos telefonosListNewTelefonosToAttach : telefonosListNew) {
                telefonosListNewTelefonosToAttach = em.getReference(telefonosListNewTelefonosToAttach.getClass(), telefonosListNewTelefonosToAttach.getId());
                attachedTelefonosListNew.add(telefonosListNewTelefonosToAttach);
            }
            telefonosListNew = attachedTelefonosListNew;
            empleados.setTelefonosList(telefonosListNew);
            List<Pagos> attachedPagosListNew = new ArrayList<Pagos>();
            for (Pagos pagosListNewPagosToAttach : pagosListNew) {
                pagosListNewPagosToAttach = em.getReference(pagosListNewPagosToAttach.getClass(), pagosListNewPagosToAttach.getId());
                attachedPagosListNew.add(pagosListNewPagosToAttach);
            }
            pagosListNew = attachedPagosListNew;
            empleados.setPagosList(pagosListNew);
            empleados = em.merge(empleados);
            for (Telefonos telefonosListOldTelefonos : telefonosListOld) {
                if (!telefonosListNew.contains(telefonosListOldTelefonos)) {
                    telefonosListOldTelefonos.setEmpleadosId(null);
                    telefonosListOldTelefonos = em.merge(telefonosListOldTelefonos);
                }
            }
            for (Telefonos telefonosListNewTelefonos : telefonosListNew) {
                if (!telefonosListOld.contains(telefonosListNewTelefonos)) {
                    Empleados oldEmpleadosIdOfTelefonosListNewTelefonos = telefonosListNewTelefonos.getEmpleadosId();
                    telefonosListNewTelefonos.setEmpleadosId(empleados);
                    telefonosListNewTelefonos = em.merge(telefonosListNewTelefonos);
                    if (oldEmpleadosIdOfTelefonosListNewTelefonos != null && !oldEmpleadosIdOfTelefonosListNewTelefonos.equals(empleados)) {
                        oldEmpleadosIdOfTelefonosListNewTelefonos.getTelefonosList().remove(telefonosListNewTelefonos);
                        oldEmpleadosIdOfTelefonosListNewTelefonos = em.merge(oldEmpleadosIdOfTelefonosListNewTelefonos);
                    }
                }
            }
            for (Pagos pagosListNewPagos : pagosListNew) {
                if (!pagosListOld.contains(pagosListNewPagos)) {
                    Empleados oldEmpleadosIdOfPagosListNewPagos = pagosListNewPagos.getEmpleadosId();
                    pagosListNewPagos.setEmpleadosId(empleados);
                    pagosListNewPagos = em.merge(pagosListNewPagos);
                    if (oldEmpleadosIdOfPagosListNewPagos != null && !oldEmpleadosIdOfPagosListNewPagos.equals(empleados)) {
                        oldEmpleadosIdOfPagosListNewPagos.getPagosList().remove(pagosListNewPagos);
                        oldEmpleadosIdOfPagosListNewPagos = em.merge(oldEmpleadosIdOfPagosListNewPagos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empleados.getId();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
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
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pagos> pagosListOrphanCheck = empleados.getPagosList();
            for (Pagos pagosListOrphanCheckPagos : pagosListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleados (" + empleados + ") cannot be destroyed since the Pagos " + pagosListOrphanCheckPagos + " in its pagosList field has a non-nullable empleadosId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Telefonos> telefonosList = empleados.getTelefonosList();
            for (Telefonos telefonosListTelefonos : telefonosList) {
                telefonosListTelefonos.setEmpleadosId(null);
                telefonosListTelefonos = em.merge(telefonosListTelefonos);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Acá se encuentra a un usuario, sirve para validar al ingresar un usuario que no se ingrese un usuario del mismo nombre
    public List encontrarUsuario(String usuario)
    {
        Query query = emf.createNamedQuery("Empleados.findByUsuario", Empleados.class);
        query.setParameter("usuario", usuario);
        return query.getResultList();
    }
    //Acá se filtra a un empleado, por medio de una consulta de MySQL
    public List filtrar(String filtrado)
    {
        Query query = emf.createNamedQuery("Empleados.filtring", Empleados.class);
        query.setParameter("nombrefilter", filtrado+"%");
        return query.getResultList();
    }
    
    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    public Empleados findEmpleados(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
