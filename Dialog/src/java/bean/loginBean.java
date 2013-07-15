/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entity.Dialog;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
EntityManagerFactory emf =Persistence.createEntityManagerFactory("DialogPU");
    EntityManager em =emf.createEntityManager();
    public String getUsername() {
        return username;
    }

    public Dialog getA1() {
        return a1;
    }

    public void setA1(Dialog a1) {
        this.a1 = a1;
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
    if(admin.getK_ad().equals(username)&&admin.getPwd().equals(password))
    {
        System.out.print("giris yaptık:D ");
        kontrol=1;
    }
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
    if(kontrol==1)
        return "admin.xhtml?faces-redirect=true";
    else
        return "loginError.xhtml?faces-redirect=true";
 
    }

    
    
    public String kaydet(){
        System.out.println("kullanıcı kaydedildi");
        
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(this.a1);
        em.getTransaction().commit();
        em.close();
        return "adminLogin.xhtml?faces-redirect=true";
    }
}
