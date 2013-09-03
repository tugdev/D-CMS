/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kategori;

import com.kategori.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author ubuntu
 */
public class KategorilerJpaController {

    public KategorilerJpaController() {
        emf = Persistence.createEntityManagerFactory("KategorilerPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Kategoriler kategoriler) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(kategoriler);
            em.getTransaction().commit();
        } finally {           if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Kategoriler kategoriler) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            kategoriler = em.merge(kategoriler);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = kategoriler.getKategoriId();
                if (findKategoriler(id) == null) {
                    throw new NonexistentEntityException("The kategoriler with id " + id + " no longer exists.");
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
            Kategoriler kategoriler;
            try {

                kategoriler = em.getReference(Kategoriler.class, id);
                kategoriler.getKategoriId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kategoriler with id " + id + " no longer exists.", enfe);
            }
            em.remove(kategoriler);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Kategoriler> findKategorilerEntities() {
        return findKategorilerEntities(true, -1, -1);
    }

    public List<Kategoriler> findKategorilerEntities(int maxResults, int firstResult) {
        return findKategorilerEntities(false, maxResults, firstResult);
    }

    private List<Kategoriler> findKategorilerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Kategoriler as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Kategoriler findKategoriler(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Kategoriler.class, id);
        } finally {
            em.close();
        }
    }

    public int getKategorilerCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Kategoriler as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
//Gelen kategori isminine ait id yi donderiyor. Bu method normalde ide tarafından oluşturulmuyor. Kendim yazdim
    public Kategoriler kategoriIdDonder(String kategoriAdi)
    {
        EntityManager em=getEntityManager();
        try{
            Query query=em.createQuery("SELECT k FROM Kategoriler k WHERE k.kategoriAdi =?").setParameter(1, kategoriAdi);;
        return (Kategoriler) query.getSingleResult();
        }finally{
            em.close();
        }
    }
    
    
}
