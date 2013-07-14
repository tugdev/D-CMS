/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tugdev;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import tugba.tugba;
/**
 *
 * @author tugdev
 */
@ManagedBean(name="Kullanıcı")
@RequestScoped
public class Kullanıcı {
     private List<tugba> liste2=new ArrayList<tugba>();
         private tugba a1=new tugba();
         private EntityManagerFactory emf = Persistence.createEntityManagerFactory("verikaydetPU");
         private EntityManager em = emf.createEntityManager();

    public List<tugba> getListe2() {
        return liste2;
    }

    public void setListe2(List<tugba> liste2) {
        this.liste2 = liste2;
    }

    public tugba getA1() {
        return a1;
    }

    public void setA1(tugba a1) {
        this.a1 = a1;
    }
   
    private List<String> liste = new ArrayList<String>();

    public List<String> getListe() {
        return liste;
    }

    public void setListe(List<String> liste) {
        this.liste = liste;
    }
    
    
    public void kaydet(){
        System.out.println("kullanıcı kaydedildi");
        
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist( this.a1 );
        em.getTransaction().commit();
        em.close();
        
    }
    
    public void listele(){
        em = emf.createEntityManager();
         em.getTransaction().begin();
         liste2=(List<tugba> ) em.createQuery("select i from tugba.tugba i").getResultList();
         em.close();
         
         
    }
    
}
