/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.kategori.Makale;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author tugdev
 */
@ManagedBean(name="MakaleBean")
@RequestScoped
public class MakaleBean implements Serializable {
     private List<Makale> liste=new ArrayList<Makale>();
     
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
         private EntityManager em = emf.createEntityManager();
   private static final long serialVersionUID = 1L;
 
    private  List<Makale> makaleler;
    private  List<Makale> makaleler2;
    private Makale makale=new Makale();

//değişken tanımla a1 olsun o zaman a1.ad diye yazcaksın listeleme işlemine
    public Makale getMakale() {
        return makale;
    }



    public List<Makale> getMakaleler2() {
        return makaleler2;
    }

    public void setMakaleler2(List<Makale> makaleler2) {
        this.makaleler2 = makaleler2;
    }

    public void setMakale(Makale makale) {
        this.makale = makale;
    }

    
        @SuppressWarnings("unchecked")
	public MakaleBean()  {
//burada "CRUDPU" bir önceki yazıda persistence-unit e verdiğimiz ad. 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
	// Önce Persistence nesnesinden EntityManaegerFactory oluşturulur.
	EntityManager em =emf.createEntityManager();
	// EntityManagerFactory'den EntityManager oluşturulur.
	makaleler=em.createQuery("select i from com.kategori.Makale i").getResultList();
  //    makaleler2=em.createQuery("select i from com.kategori.Makale i where i.yazar=com.Bean.KullaniciManaged.kullanici.ad ").getResultList();
        makaleler2=em.createQuery("select i from com.kategori.Makale i where i.yazar='tugdev'").getResultList();
    //    kullaniciManaged.kullanici.ad
	//ust tarafta olusturdugum kisiler adlı liste bilgiler kaydettik.select * from tugba where ad="tugba"
	em.close();
	emf.close();
}

    public List<Makale> getListe() {
        return liste;
    }

    public void setListe(List<Makale> liste) {
        this.liste = liste;
    }

    public List<Makale> getMakaleler() {
        return makaleler;
    }

    public void setMakaleler(List<Makale> makaleler) {
        this.makaleler = makaleler;
    }
	
	
	public String KAYDET(){ //veritabanımıza insert işlemlerinin gerçekleştirildiği fonksiyon 
            // sürekli olarak EntityManagerFactory ve EntityManager ürettiğimiz için
            // perpormans sorunlarıyla karşılaşabilirz.Faces-config de	ContextListener tanımlayarak
            // performansımızı arttırabiliriz.
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
            EntityManager em = emf.createEntityManager();
            
          
         
            em.getTransaction().begin();
            em.persist(this.makale);
           
            em.getTransaction().commit();
            em.close();
            emf.close();
            System.out.println("Kaydedildi...");
        return "giris.xhtml?faces-redirect=true";


	
}
	public String SIL(){ //veritabanımıza Delete işlemlerinin gerçekleştirildiği fonksiyon
            
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
            EntityManager em = emf.createEntityManager();
            makale = em.find(makale.getClass(), makale.getId()); 
            //em.find ile veritabanımızdaki verdiğimiz id numarasını içeren kayıtı bulup üst tarafta 
            //tanımladığım user adlı nesnemize atıyoruz.
            em.getTransaction().begin();
            em.remove(this.makale);
            em.getTransaction().commit(); 
            em.close();	
            emf.close();
            System.out.println("Silindi...");

            return "giris.xhtml?faces-redirect=true";
}
	public String GUNCELLE(){ //veritabanımıza update işlemlerinin gerçekleştirildiği fonksiyon
            if(makale.getId()>0){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Makale userx=em.find(makale.getClass(), makale.getId());
            userx.setBaslik(makale.getBaslik());
            userx.setIcerik(makale.getIcerik());
            userx.setYazar(makale.getYazar());
            em.getTransaction().commit();
            em.close();
            emf.close();
            System.out.println("Güncelendi...");
            }
                          return "index";
                  }
        
       public void listele(){
            em = emf.createEntityManager();
             em.getTransaction().begin();
             liste=(List<Makale> ) em.createQuery("select i from com.kategori.Makale i").getResultList();
             em.close();

         
    }
}