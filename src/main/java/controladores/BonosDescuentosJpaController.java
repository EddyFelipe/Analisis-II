/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import entidades.BonosDescuentos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Detallepagos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
        if (bonosDescuentos.getDetallepagosList() == null) {
            bonosDescuentos.setDetallepagosList(new ArrayList<Detallepagos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Detallepagos> attachedDetallepagosList = new ArrayList<Detallepagos>();
            for (Detallepagos detallepagosListDetallepagosToAttach : bonosDescuentos.getDetallepagosList()) {
                detallepagosListDetallepagosToAttach = em.getReference(detallepagosListDetallepagosToAttach.getClass(), detallepagosListDetallepagosToAttach.getId());
                attachedDetallepagosList.add(detallepagosListDetallepagosToAttach);
            }
            bonosDescuentos.setDetallepagosList(attachedDetallepagosList);
            em.persist(bonosDescuentos);
            for (Detallepagos detallepagosListDetallepagos : bonosDescuentos.getDetallepagosList()) {
                BonosDescuentos oldBonosDescuentosIdOfDetallepagosListDetallepagos = detallepagosListDetallepagos.getBonosDescuentosId();
                detallepagosListDetallepagos.setBonosDescuentosId(bonosDescuentos);
                detallepagosListDetallepagos = em.merge(detallepagosListDetallepagos);
                if (oldBonosDescuentosIdOfDetallepagosListDetallepagos != null) {
                    oldBonosDescuentosIdOfDetallepagosListDetallepagos.getDetallepagosList().remove(detallepagosListDetallepagos);
                    oldBonosDescuentosIdOfDetallepagosListDetallepagos = em.merge(oldBonosDescuentosIdOfDetallepagosListDetallepagos);
                }
            }
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
            BonosDescuentos persistentBonosDescuentos = em.find(BonosDescuentos.class, bonosDescuentos.getId());
            List<Detallepagos> detallepagosListOld = persistentBonosDescuentos.getDetallepagosList();
            List<Detallepagos> detallepagosListNew = bonosDescuentos.getDetallepagosList();
            List<Detallepagos> attachedDetallepagosListNew = new ArrayList<Detallepagos>();
            for (Detallepagos detallepagosListNewDetallepagosToAttach : detallepagosListNew) {
                detallepagosListNewDetallepagosToAttach = em.getReference(detallepagosListNewDetallepagosToAttach.getClass(), detallepagosListNewDetallepagosToAttach.getId());
                attachedDetallepagosListNew.add(detallepagosListNewDetallepagosToAttach);
            }
            detallepagosListNew = attachedDetallepagosListNew;
            bonosDescuentos.setDetallepagosList(detallepagosListNew);
            bonosDescuentos = em.merge(bonosDescuentos);
            for (Detallepagos detallepagosListOldDetallepagos : detallepagosListOld) {
                if (!detallepagosListNew.contains(detallepagosListOldDetallepagos)) {
                    detallepagosListOldDetallepagos.setBonosDescuentosId(null);
                    detallepagosListOldDetallepagos = em.merge(detallepagosListOldDetallepagos);
                }
            }
            for (Detallepagos detallepagosListNewDetallepagos : detallepagosListNew) {
                if (!detallepagosListOld.contains(detallepagosListNewDetallepagos)) {
                    BonosDescuentos oldBonosDescuentosIdOfDetallepagosListNewDetallepagos = detallepagosListNewDetallepagos.getBonosDescuentosId();
                    detallepagosListNewDetallepagos.setBonosDescuentosId(bonosDescuentos);
                    detallepagosListNewDetallepagos = em.merge(detallepagosListNewDetallepagos);
                    if (oldBonosDescuentosIdOfDetallepagosListNewDetallepagos != null && !oldBonosDescuentosIdOfDetallepagosListNewDetallepagos.equals(bonosDescuentos)) {
                        oldBonosDescuentosIdOfDetallepagosListNewDetallepagos.getDetallepagosList().remove(detallepagosListNewDetallepagos);
                        oldBonosDescuentosIdOfDetallepagosListNewDetallepagos = em.merge(oldBonosDescuentosIdOfDetallepagosListNewDetallepagos);
                    }
                }
            }
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
            List<Detallepagos> detallepagosList = bonosDescuentos.getDetallepagosList();
            for (Detallepagos detallepagosListDetallepagos : detallepagosList) {
                detallepagosListDetallepagos.setBonosDescuentosId(null);
                detallepagosListDetallepagos = em.merge(detallepagosListDetallepagos);
            }
            em.remove(bonosDescuentos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BonosDescuentos> findBonosDescuentosEntities() {
        return findBonosDescuentosEntities(true, -1, -1);
    }

    public List<BonosDescuentos> findBonosDescuentosEntities(int maxResults, int firstResult) {
        return findBonosDescuentosEntities(false, maxResults, firstResult);
    }
    //Acá se obtiene un bono/descuento, pues se utiliza para validar al agregar un bono/descuento que exista uno con el mismo nombre
    public List encontrarBono_Descuento(String bono_descuento)
    {
        Query query = emf.createNamedQuery("BonosDescuentos.findByDescripci\u00f3n", BonosDescuentos.class);
        query.setParameter("descripci\u00f3n", bono_descuento);
        return query.getResultList();
    }
    //Acá se filtran los bonos/descuentos por medio de una consulta de MySQL
    public List filtrar(String bono_descuento)
    {
        Query query = emf.createNamedQuery("BonosDescuentos.filtring", BonosDescuentos.class);
        query.setParameter("descripcion", bono_descuento + "%");
        return query.getResultList();
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
