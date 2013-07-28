/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Makale;
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
     
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projePU");
         private EntityManager em = emf.createEntityManager();
   private static final long serialVersionUID = 1L;
    
    private  List<Makale> makaleler;
    private Makale makale=new Makale();

    public Makale getMakale() {
        return makale;
    }

    public void setMakale(Makale makale) {
        this.makale = makale;
    }
    
//    public String reinit() {  
//        makale = new Makale();  
//          
//        return null;  
//    }  
    
        @SuppressWarnings("unchecked")
	public MakaleBean()  {
//burada "CRUDPU" bir önceki yazıda persistence-unit e verdiğimiz ad. 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projePU");
	// Önce Persistence nesnesinden EntityManaegerFactory oluşturulur.
	EntityManager em =emf.createEntityManager();
	// EntityManagerFactory'den EntityManager oluşturulur.
	makaleler=em.createQuery("select i from entity.Makale i").getResultList();
	//ust tarafta olusturdugum kisiler adlı liste bilgiler kaydettik.
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
	
	
	public void KAYDET(){ //veritabanımıza insert işlemlerinin gerçekleştirildiği fonksiyon 
            // sürekli olarak EntityManagerFactory ve EntityManager ürettiğimiz için
            // perpormans sorunlarıyla karşılaşabilirz.Faces-config de	ContextListener tanımlayarak
            // performansımızı arttırabiliriz.
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("projePU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(this.makale);
            em.getTransaction().commit();
            em.close();
            emf.close();
            System.out.println("Kaydedildi...");



	
}
	public String SIL(){ //veritabanımıza Delete işlemlerinin gerçekleştirildiği fonksiyon
 
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("projePU");
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

            return "index";
}
	public String GUNCELLE(){ //veritabanımıza update işlemlerinin gerçekleştirildiği fonksiyon
            if(makale.getId()>0){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("projePU");
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
             liste=(List<Makale> ) em.createQuery("select i from entity.Makale i").getResultList();
             em.close();

         
    }
}