/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Dialog;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author tugdev
 */
@ManagedBean(name="loginBean")
@RequestScoped
public class loginBean {
private String username;
private String password;
private List admins;
Iterator sayacY;
private Dialog admin;
private Dialog a1=new Dialog();
    
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("projePU");
    EntityManager em =emf.createEntityManager();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List getAdmins() {
        return admins;
    }

    public void setAdmins(List admins) {
        this.admins = admins;
    }

    public Dialog getA1() {
        return a1;
    }

    public void setA1(Dialog a1) {
        this.a1 = a1;
    }
    
    public String girisYap()
    {
    int kontrol=0;
    List getir;
    try
    {
    
    em.getTransaction().begin();
    Query sorgu=em.createQuery("FROM Dialog");
    getir=sorgu.getResultList();
 
    for(sayacY=getir.iterator();sayacY.hasNext();)
    {
        admin=(Dialog)sayacY.next();
    
        if ("admin".equals(username)&&"admin".equals(password))
      {
        System.out.print("giris yaptık:D ");
        kontrol=2;
      }
     
       else if (admin.getK_ad().equals(username)&&admin.getPwd().equals(password))
     {
        System.out.print("giris yaptık:D ");
        kontrol=1;
    }
//    if (admin.getK_ad().equals(username)&&admin.getPwd().equals(password))
//     {
//        System.out.print("giris yaptık:D ");
//        kontrol=1;
//    }
    else
        System.out.print("yokmuş:D ");
    }
    em.getTransaction().commit();
    em.close();
    emf.close();
    }
    catch (Exception e) {
        System.out.println("olmadı : "+ e);
    }
    
    if(kontrol==2)
         return "adminim.xhtml?faces-redirect=true";
    else if(kontrol==1)
        return "hosgeldin.xhtml?faces-redirect=true";
    else
        return "loginError.xhtml?faces-redirect=true";
 
    }

 

    
    
    public String kaydet(){
       
        if(a1.getK_ad().equals("") || a1.getPwd().equals(""))
        {
        
        return "loginError.xhtml?faces-redirect=true";
        }
        else{
             System.out.println("kullanıcı kaydedildi");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
        
            
       
        em.persist(this.a1);
        em.getTransaction().commit();
        em.close();
        return "index.xhtml?faces-redirect=true";
         }
    }
}
