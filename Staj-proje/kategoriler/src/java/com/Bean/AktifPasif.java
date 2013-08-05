/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.kategori.Aktif;
import com.kategori.Pasif;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SUMEYRA
 */
@ManagedBean(name = "aktifpasif")
@RequestScoped
public class AktifPasif {
    
    private Aktif a1=new Aktif();
    private Pasif a2=new Pasif();
    private List<Aktif> liste = new ArrayList<Aktif>();
    private List<Pasif> liste2 = new ArrayList<Pasif>();
    
    
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("KategorilerPU");
    EntityManager em =emf.createEntityManager();

    public List<Aktif> getListe() {
        return liste;
    }

    public void setListe(List<Aktif> liste) {
        this.liste = liste;
    }

    public List<Pasif> getListe2() {
        return liste2;
    }

    public void setListe2(List<Pasif> liste2) {
        this.liste2 = liste2;
    }
    

    public Aktif getA1() {
        return a1;
    }

    public void setA1(Aktif a1) {
        this.a1 = a1;
    }

    public Pasif getA2() {
        return a2;
    }

    public void setA2(Pasif a2) {
        this.a2 = a2;
    }

    public void pasifKaydet(){
        
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(this.a2);
        em.getTransaction().commit();
        em.close();
}
    
    public void aktifKaydet(){
        
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(this.a1);
        em.getTransaction().commit();
        em.close();
}
    public void aktifSil(){
        
    a1 = em.find(a1.getClass(), a1.getId()); 
    em.getTransaction().begin();
    em.remove(this.a1);
    em.getTransaction().commit(); 
    em.close();
    }
    
    public void pasifSil(){
        
    a2 = em.find(a2.getClass(), a2.getId()); 
    em.getTransaction().begin();
    em.remove(this.a2);
    em.getTransaction().commit(); 
    em.close();
    }
    
}
