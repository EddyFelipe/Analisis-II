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
import entidades.Compra;
import entidades.Compras;
import java.util.ArrayList;
import java.util.List;
import entidades.Telefonos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author User
 */
public class ComprasJpaController implements Serializable {

    public ComprasJpaController(EntityManager emf) {
        this.emf = emf;
    }
    private EntityManager emf = null;

    public EntityManager getEntityManager() {
        return emf;
    }

    public void create(Compras compras) {
        if (compras.getCompraList() == null) {
            compras.setCompraList(new ArrayList<Compra>());
        }
        if (compras.getTelefonosList() == null) {
            compras.setTelefonosList(new ArrayList<Telefonos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Compra> attachedCompraList = new ArrayList<Compra>();
            for (Compra compraListCompraToAttach : compras.getCompraList()) {
                compraListCompraToAttach = em.getReference(compraListCompraToAttach.getClass(), compraListCompraToAttach.getId());
                attachedCompraList.add(compraListCompraToAttach);
            }
            compras.setCompraList(attachedCompraList);
            List<Telefonos> attachedTelefonosList = new ArrayList<Telefonos>();
            for (Telefonos telefonosListTelefonosToAttach : compras.getTelefonosList()) {
                telefonosListTelefonosToAttach = em.getReference(telefonosListTelefonosToAttach.getClass(), telefonosListTelefonosToAttach.getId());
                attachedTelefonosList.add(telefonosListTelefonosToAttach);
            }
            compras.setTelefonosList(attachedTelefonosList);
            em.persist(compras);
            for (Compra compraListCompra : compras.getCompraList()) {
                Compras oldComprasIdcomprasOfCompraListCompra = compraListCompra.getComprasIdcompras();
                compraListCompra.setComprasIdcompras(compras);
                compraListCompra = em.merge(compraListCompra);
                if (oldComprasIdcomprasOfCompraListCompra != null) {
                    oldComprasIdcomprasOfCompraListCompra.getCompraList().remove(compraListCompra);
                    oldComprasIdcomprasOfCompraListCompra = em.merge(oldComprasIdcomprasOfCompraListCompra);
                }
            }
            for (Telefonos telefonosListTelefonos : compras.getTelefonosList()) {
                Compras oldComprasIdcomprasOfTelefonosListTelefonos = telefonosListTelefonos.getComprasIdcompras();
                telefonosListTelefonos.setComprasIdcompras(compras);
                telefonosListTelefonos = em.merge(telefonosListTelefonos);
                if (oldComprasIdcomprasOfTelefonosListTelefonos != null) {
                    oldComprasIdcomprasOfTelefonosListTelefonos.getTelefonosList().remove(telefonosListTelefonos);
                    oldComprasIdcomprasOfTelefonosListTelefonos = em.merge(oldComprasIdcomprasOfTelefonosListTelefonos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compras compras) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compras persistentCompras = em.find(Compras.class, compras.getIdcompras());
            List<Compra> compraListOld = persistentCompras.getCompraList();
            List<Compra> compraListNew = compras.getCompraList();
            List<Telefonos> telefonosListOld = persistentCompras.getTelefonosList();
            List<Telefonos> telefonosListNew = compras.getTelefonosList();
            List<String> illegalOrphanMessages = null;
            for (Compra compraListOldCompra : compraListOld) {
                if (!compraListNew.contains(compraListOldCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Compra " + compraListOldCompra + " since its comprasIdcompras field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Compra> attachedCompraListNew = new ArrayList<Compra>();
            for (Compra compraListNewCompraToAttach : compraListNew) {
                compraListNewCompraToAttach = em.getReference(compraListNewCompraToAttach.getClass(), compraListNewCompraToAttach.getId());
                attachedCompraListNew.add(compraListNewCompraToAttach);
            }
            compraListNew = attachedCompraListNew;
            compras.setCompraList(compraListNew);
            List<Telefonos> attachedTelefonosListNew = new ArrayList<Telefonos>();
            for (Telefonos telefonosListNewTelefonosToAttach : telefonosListNew) {
                telefonosListNewTelefonosToAttach = em.getReference(telefonosListNewTelefonosToAttach.getClass(), telefonosListNewTelefonosToAttach.getId());
                attachedTelefonosListNew.add(telefonosListNewTelefonosToAttach);
            }
            telefonosListNew = attachedTelefonosListNew;
            compras.setTelefonosList(telefonosListNew);
            compras = em.merge(compras);
            for (Compra compraListNewCompra : compraListNew) {
                if (!compraListOld.contains(compraListNewCompra)) {
                    Compras oldComprasIdcomprasOfCompraListNewCompra = compraListNewCompra.getComprasIdcompras();
                    compraListNewCompra.setComprasIdcompras(compras);
                    compraListNewCompra = em.merge(compraListNewCompra);
                    if (oldComprasIdcomprasOfCompraListNewCompra != null && !oldComprasIdcomprasOfCompraListNewCompra.equals(compras)) {
                        oldComprasIdcomprasOfCompraListNewCompra.getCompraList().remove(compraListNewCompra);
                        oldComprasIdcomprasOfCompraListNewCompra = em.merge(oldComprasIdcomprasOfCompraListNewCompra);
                    }
                }
            }
            for (Telefonos telefonosListOldTelefonos : telefonosListOld) {
                if (!telefonosListNew.contains(telefonosListOldTelefonos)) {
                    telefonosListOldTelefonos.setComprasIdcompras(null);
                    telefonosListOldTelefonos = em.merge(telefonosListOldTelefonos);
                }
            }
            for (Telefonos telefonosListNewTelefonos : telefonosListNew) {
                if (!telefonosListOld.contains(telefonosListNewTelefonos)) {
                    Compras oldComprasIdcomprasOfTelefonosListNewTelefonos = telefonosListNewTelefonos.getComprasIdcompras();
                    telefonosListNewTelefonos.setComprasIdcompras(compras);
                    telefonosListNewTelefonos = em.merge(telefonosListNewTelefonos);
                    if (oldComprasIdcomprasOfTelefonosListNewTelefonos != null && !oldComprasIdcomprasOfTelefonosListNewTelefonos.equals(compras)) {
                        oldComprasIdcomprasOfTelefonosListNewTelefonos.getTelefonosList().remove(telefonosListNewTelefonos);
                        oldComprasIdcomprasOfTelefonosListNewTelefonos = em.merge(oldComprasIdcomprasOfTelefonosListNewTelefonos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compras.getIdcompras();
                if (findCompras(id) == null) {
                    throw new NonexistentEntityException("The compras with id " + id + " no longer exists.");
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
            Compras compras;
            try {
                compras = em.getReference(Compras.class, id);
                compras.getIdcompras();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compras with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Compra> compraListOrphanCheck = compras.getCompraList();
            for (Compra compraListOrphanCheckCompra : compraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compras (" + compras + ") cannot be destroyed since the Compra " + compraListOrphanCheckCompra + " in its compraList field has a non-nullable comprasIdcompras field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Telefonos> telefonosList = compras.getTelefonosList();
            for (Telefonos telefonosListTelefonos : telefonosList) {
                telefonosListTelefonos.setComprasIdcompras(null);
                telefonosListTelefonos = em.merge(telefonosListTelefonos);
            }
            em.remove(compras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Se filtra un listado de empresas por medio de una consulta de MySQL
    public List filtrar(String contenido)
    {
        Query query = emf.createNamedQuery("Compras.filtrar", Compras.class);
        query.setParameter("empresa", contenido + "%");
        return query.getResultList();
    }

    public List<Compras> findComprasEntities() {
        return findComprasEntities(true, -1, -1);
    }

    public List<Compras> findComprasEntities(int maxResults, int firstResult) {
        return findComprasEntities(false, maxResults, firstResult);
    }

    private List<Compras> findComprasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compras.class));
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

    public Compras findCompras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compras.class, id);
        } finally {
            em.close();
        }
    }

    public int getComprasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compras> rt = cq.from(Compras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
