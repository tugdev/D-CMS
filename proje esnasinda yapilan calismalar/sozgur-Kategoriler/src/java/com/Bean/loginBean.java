/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.kategori.Dialog;
import com.kategori.Kategoriler;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author SUMEYRA
 */
public class loginBean {

   private String username;
   private String password;
   private List admins;
   Iterator sayacY;
   private Dialog admin;
   private Dialog a1=new Dialog();
   private Dialog ekleKullanici;
   private List<Dialog> kisilerliste = new ArrayList<Dialog>();
   
     
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("KategorilerPU");
    EntityManager em =emf.createEntityManager();
  

    public List<Dialog> getKisilerliste() {
        return kisilerliste;
    }

    public void setKisilerliste(List<Dialog> kisilerliste) {
        this.kisilerliste = kisilerliste;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public Dialog getEkleKullanici() {
        return ekleKullanici;
    }

    public void setEkleKullanici(Dialog ekleKullanici) {
        this.ekleKullanici = ekleKullanici;
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
    private static boolean isSessionOpen;

    public static boolean isIsSessionOpen() {
        return isSessionOpen;
    }

    public static void setIsSessionOpen(boolean isSessionOpen) {
        loginBean.isSessionOpen = isSessionOpen;
    }
    private static List<Dialog> kullanicilar=new ArrayList<Dialog>();
    
    public boolean checkValidUser() {
        //selectRealAdmin();

        if (a1.getK_ad() != null ) {
            for (Dialog real : kullanicilar) {
                if (a1.getK_ad().equals(real.getK_ad())) {


                    if (getMD5(a1.getPwd()).equals(real.getPwd())) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
     @PostConstruct
    public void kullaniciConst() {

         boolean b;
        b = checkValidUser();
        setIsSessionOpen(b);
     
        if (this.ekleKullanici == null) {
            this.ekleKullanici = new Dialog();

        }
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
    

        if (admin.getK_ad().equals("admin")&&admin.getPwd().equals("admin"))
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Admin giriş."));
            ekleKullanici = new Dialog();
        kontrol=2;
      }
        else if("".equals(admin.getK_ad())|| "".equals(admin.getPwd())){
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "lütfen bşlukları doldurunuz."));
            ekleKullanici = new Dialog();
        kontrol=3;
        }
       else if (admin.getK_ad().equals(username)&&admin.getPwd().equals(password)&&admin.getAkpa().equals(0))
     {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Kullanıcı Girisi."));
            ekleKullanici = new Dialog();
        kontrol=1;
    }
       else if (admin.getK_ad().equals(username)&&admin.getPwd().equals(password)&&admin.getAkpa().equals(1))
     {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Kullanıcı Pasif Durumda."));
            ekleKullanici = new Dialog();
        kontrol=3;
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
    
    if(kontrol==2)
         return "index.xhtml?faces-redirect=true";
    else if(kontrol==3)
        return "anasayfa.xhtml?faces-redirect=true";
    else if(kontrol==1)
        return "hosgeldin.xhtml?faces-redirect=true";
    else
        return "anasayfa.xhtml?faces-redirect=true";
 
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
        a1.setAkpa(0);
        em.persist(this.a1);
        em.getTransaction().commit();
        em.close();
        return "anasayfa.xhtml?faces-redirect=true";
         }
    }
     public String cikisButon() {
        a1 = new Dialog();
        ekleKullanici = new Dialog();
 return "anasayfa.xhtml?faces-redirect=true";
        
    }
     
     
        @SuppressWarnings("unchecked")
	public loginBean()  {
//burada "CRUDPU" bir önceki yazıda persistence-unit e verdiğimiz ad. 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
	// Önce Persistence nesnesinden EntityManaegerFactory oluşturulur.
	EntityManager em =emf.createEntityManager();
	// EntityManagerFactory'den EntityManager oluşturulur.
	kisilerliste=em.createQuery("select i from com.kategori.Dialog i").getResultList();
	//ust tarafta olusturdugum kisiler adlı liste bilgiler kaydettik.
	em.close();
	emf.close();
}
        
         public void pasif() throws NoSuchAlgorithmException { //veritabanımıza Delete işlemlerinin gerçekleştirildiği fonksiyon     
        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Dialog user=em.find(a1.getClass(), a1.getId());
            user.setAkpa(1);
            em.getTransaction().commit();
            em.close();
            emf.close();
}
           public void aktif() throws NoSuchAlgorithmException { //veritabanımıza Delete işlemlerinin gerçekleştirildiği fonksiyon     
        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Dialog user=em.find(a1.getClass(), a1.getId());
            user.setAkpa(0);
            em.getTransaction().commit();
            em.close();
            emf.close();
}
}

