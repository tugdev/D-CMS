/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import entity.Dialog;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.primefaces.context.RequestContext;
/**
 *
 * @author tugdev
 */
@ManagedBean(name="DialogBean")
@RequestScoped
public class DialogBean {
  
    private Dialog a1=new Dialog();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DialogPU");
    private EntityManager em = emf.createEntityManager();

    public Dialog getA1() {
        return a1;
    }

    public void setA1(Dialog a1) {
        this.a1 = a1;
    }
    
    public void Login() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn = false;
		
		  
     //            if(a1.getK_ad() != null  && a1.getK_ad().equals("admin") && a1.getPwd() != null  && a1.getPwd().equals("admin")) {    
              if((a1.getK_ad() != null && a1.getK_ad().equals("admin")) || (a1.getPwd() != null && a1.getPwd().equals("admin")) ){
                
                loggedIn = true;
                
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Hoşgeldin "+ a1.getK_ad(),a1.getK_ad());
		} else {
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("loggedIn", loggedIn);
	}
    
    
}
