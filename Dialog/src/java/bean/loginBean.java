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
    
    
    public String girisYap()
    {
    int kontrol=0;
List     getir;
    try
    {
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("DialogPU");
    EntityManager em =emf.createEntityManager();
    em.getTransaction().begin();
    Query sorgu=em.createQuery("FROM Dialog");
    getir=sorgu.getResultList();
 
    for(sayacY=getir.iterator();sayacY.hasNext();)
    {
        admin=(Dialog)sayacY.next();
    if(admin.getK_ad().equals(username)&&admin.getPwd().equals(password))
    {
        System.out.print("girdik:D ");
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

    
    
}
