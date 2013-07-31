/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entity.Kisi;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


  


@ManagedBean(name="MyBean")
@RequestScoped
public class MyBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private  List<Kisi> kisiler;
	private Kisi user=new Kisi();
	
	public void setUser(Kisi user) {
		this.user = user;
	}
	public Kisi getUser() {
		return user;
	}
	@SuppressWarnings("unchecked")
	public MyBean()  {
//burada "CRUDPU" bir önceki yazıda persistence-unit e verdiğimiz ad. 
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUDPU");
	// Önce Persistence nesnesinden EntityManaegerFactory oluşturulur.
	EntityManager em =emf.createEntityManager();
	// EntityManagerFactory'den EntityManager oluşturulur.
	kisiler=em.createQuery("select i from entity.Kisi i").getResultList();
	//ust tarafta olusturdugum kisiler adlı liste bilgiler kaydettik.
	em.close();
	emf.close();
	}
	
	public List<Kisi> getKisiler() {
		return kisiler;
	} 
	
	public String KAYDET(){ //veritabanımıza insert işlemlerinin gerçekleştirildiği fonksiyon 
	// sürekli olarak EntityManagerFactory ve EntityManager ürettiğimiz için
	// perpormans sorunlarıyla karşılaşabilirz.Faces-config de	ContextListener tanımlayarak
	// performansımızı arttırabiliriz.
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUDPU");
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
  em.persist(this.user);
  em.getTransaction().commit();
  em.close();
  emf.close();
  System.out.println("Kaydedildi...");
                
  
  return "index";
	
}
	public String SIL(){ //veritabanımıza Delete işlemlerinin gerçekleştirildiği fonksiyon
  
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUDPU");
  EntityManager em = emf.createEntityManager();
  user = em.find(user.getClass(), user.getId()); 
  //em.find ile veritabanımızdaki verdiğimiz id numarasını içeren kayıtı bulup üst tarafta 
  //tanımladığım user adlı nesnemize atıyoruz.
  em.getTransaction().begin();
  em.remove(this.user);
  em.getTransaction().commit(); 
  em.close();	
  emf.close();
  System.out.println("Silindi...");
  
  return "index";
}
	public String GUNCELLE(){ //veritabanımıza update işlemlerinin gerçekleştirildiği fonksiyon
  if(user.getId()>0){
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUDPU");
  EntityManager em = emf.createEntityManager();
  em.getTransaction().begin();
  Kisi userx=em.find(user.getClass(), user.getId());
  userx.setAdi(user.getAdi());
  userx.setSoyadi((user.getSoyadi()));
  em.getTransaction().commit();
  em.close();
  emf.close();
  System.out.println("Güncelendi...");
  }
		return "index";
	}
        
   
}