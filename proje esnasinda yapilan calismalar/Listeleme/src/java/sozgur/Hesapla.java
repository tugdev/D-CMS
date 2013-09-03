/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sozgur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Query;
import org.hibernate.Transaction;
import ozgur.Dell;

/**
 *
 * @author sozgur
 */
@ManagedBean(name="Hesapla")
@RequestScoped
public class Hesapla {
         private List<Dell> liste2=new ArrayList<Dell>();
         private Dell a1=new Dell();
         private EntityManagerFactory emf = Persistence.createEntityManagerFactory("HesapMakDbPU");
         private EntityManager em = emf.createEntityManager();
         
public Dell getA1() {
        return a1;
    }

    public void setA1(Dell a1) {
        this.a1 = a1;
    }
 
     private float sayi1;
     private float sayi2;
     private float sonuc;
    // private ArrayList<String> liste;
     private List<String> liste = new ArrayList<String>();

    public List<Dell> getListe2() {
        return liste2;
    }

    public void setListe2(List<Dell> liste2) {
        this.liste2 = liste2;
    }

    

    public List<String> getListe() {
        return liste;
    }

    public void setListe(List<String> liste) {
        this.liste = liste;
    }

   
   
     

    public float getSayi1() {
        return sayi1;
    }

    public void setSayi1(float sayi1) {
        this.sayi1 = sayi1;
    }

    public float getSayi2() {
        return sayi2;
    }

    public void setSayi2(float sayi2) {
        this.sayi2 = sayi2;
    }

    public float getSonuc() {
        return sonuc;
    }

    public void setSonuc(float sonuc) {
        this.sonuc = sonuc;
    }
     
        
    public void Topla() {
        
        a1.setTplm(a1.getSy1()+a1.getSy2());
        System.out.println(sonuc);
    
  
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist( a1 );
        em.getTransaction().commit();
        em.close();
}  
 
    public void Listele() {
      
         em = emf.createEntityManager();
         em.getTransaction().begin();
         liste2=(List<Dell> ) em.createQuery("select i from ozgur.Dell i").getResultList();
         em.close();
    
      

  
   
    
}
      
    

         
   
}
