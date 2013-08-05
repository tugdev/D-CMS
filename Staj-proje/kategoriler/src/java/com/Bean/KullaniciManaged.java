/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.kategori.Kullanici;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

@javax.faces.bean.ManagedBean
@SessionScoped
@RequestScoped
public class KullaniciManaged implements PhaseListener {

   private static Kullanici kullanici=new Kullanici();
   EntityManagerFactory emf =Persistence.createEntityManagerFactory("KategorilerPU");
   private EntityManager em;
   private static List<Kullanici> kullanicilar=new ArrayList<Kullanici>();
   private Kullanici ekleKullanici;
   private Kullanici sil;
   private String ad;
   private String sifre;

    public Kullanici getEkleKullanici() {
        return ekleKullanici;
    }

    public void setEkleKullanici(Kullanici ekleKullanici) {
        this.ekleKullanici = ekleKullanici;
    }

    public Kullanici getSil() {
        return sil;
    }

    public void setSil(Kullanici sil) {
        this.sil = sil;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        KullaniciManaged.kullanici = kullanici;
    }

    public List<Kullanici> getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(List<Kullanici> kullanicilar) {
        KullaniciManaged.kullanicilar = kullanicilar;
    }
   
   
     @PostConstruct
    public void kullaniciConst() {

         boolean b;
        b = checkValidUser();
        setIsSessionOpen(b);
     
        if (this.ekleKullanici == null) {
            this.ekleKullanici = new Kullanici();

        }
    }
      public String dene() throws NoSuchAlgorithmException {
      int t=0;

        em = emf.createEntityManager();
        em.getTransaction().begin();
        kullanicilar = (List<Kullanici>) em.createQuery("select i from com.kategori.Kullanici i").getResultList();

       if ("".equals(kullanici.getAd()) || ("".equals(kullanici.getSifre()))|| "".equals(kullanici.getRol())) {
    
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Bilgilendirme:Lütfen İlgili Tüm Boşlukları Doldurunuz."));
            ekleKullanici = new Kullanici();
            t=1;
             
          //  return "kullaniciEkle.xhtml?faces-redirect=true";
        }

        for (Kullanici k : kullanicilar) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(kullanici.getSifre().getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            System.out.println("Digest(in hex format):: " + sb.toString());
            
            if ((k.getAd().equals(kullanici.getAd())) && k.getSifre().equals(sb.toString())) {
                    
                kullanici.setId(k.getId());
                kullanici.setRol(k.getRol());
                em.close();
                return "giris.xhtml?faces-redirect=true";
               
            }
        }
        if(t==0)
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null, "Bilgilendirme:Yanlis Kullanici Adi Veya Sifre"));
        em.close();
        return "";
    }
      
    public void ekle() throws NoSuchAlgorithmException {
           String[] roles = null;
           
           int bak=0;
           int b = 0;
       
         
          if(ekleKullanici.getSifre().length()>=4)
          {
              
            if ("".equals(ekleKullanici.getAd()) || "".equals(ekleKullanici.getSifre()) || "".equals(ekleKullanici.getRol())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Bilgilendirme:Lütfen Tüm Boşlukları Doldurunuz."));
            ekleKullanici = new Kullanici();
            b=1;

          //  return "kullaniciEkle.xhtml?faces-redirect=true";
        } else {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            bak = 0;
            kullanicilar = (List<Kullanici>) em.createQuery("select i from com.kategori.Kullanici i").getResultList();
            for (Kullanici l : kullanicilar) {
                if (ekleKullanici.getAd().equals(l.getAd())) {
                    bak = 1;

                }
            }
            if (bak == 0) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(ekleKullanici.getSifre().getBytes());

                byte byteData[] = md.digest();

                //convert the byte to hex format method 1
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                }

                System.out.println("Digest(in hex format):: " + sb.toString());
FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Yeni Kullanici Oluşturulmuştur ."));
                ekleKullanici.setSifre(sb.toString());
                em.persist(this.ekleKullanici);
 kullanicilar = (List<Kullanici>) em.createQuery("select i from com.kategori.Kullanici i").getResultList();
            }

            if (bak == 1 && b==0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Kullanici Adi Kullanilmaktadır. Lütfen Yeni Bir Kullanici Adi Deneyin ."));
                ekleKullanici = new Kullanici();
         //       return "kullaniciEkle.xhtml?faces-redirect=true";
            }
            em.getTransaction().commit();
            em.close();
            ekleKullanici = new Kullanici();
        //    return "giris.xhtml?faces-redirect=true";
       }
      }else{
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "Şifre en az 4 karakterleri olmalıdır."));
               ekleKullanici = new Kullanici();
              
           }
  }
    public String cikisButon() {
        kullanici = new Kullanici();
        ekleKullanici = new Kullanici();
 return "login.xhtml?faces-redirect=true";
        
    }

    public String iptalButton() {

        ekleKullanici = new Kullanici();
       return "giris.xhtml?faces-redirect=true";
    }

    public void temizle() {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null,"Ekran Temizlendi."));
        ekleKullanici = new Kullanici();
    //    return "kullaniciEkle.xhtml?faces-redirect=true";
    }

    public void araTemizle() {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null, "Ekran Temizlendi."));
        kullanici = new Kullanici();
       
      //  return "index.xhtml?faces-redirect=true";
    }

    public void silKullanici()  {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        int dene = 0;
        kullanicilar = (List<Kullanici>) em.createQuery("select i from com.kategori.Kullanici i").getResultList();

        if (kullanici.getAd().equals(sil.getAd())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Açık Olan Hesap Silinemez. Lütfen Daha Sonra Tekrar Deneyin."));
            ekleKullanici = new Kullanici();
            dene = 1;
           // return "kullaniciEkle.xhtml?faces-redirect=true";
        } else {


            for (Kullanici k : kullanicilar) {

                if ((k.getAd().equals(sil.getAd()))) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Bilgilendirme:Kullanici Silindi"));
                    em.remove(k);
                    dene = 1;
 kullanicilar = (List<Kullanici>) em.createQuery("select i from com.kategori.Kullanici i").getResultList();
                }

            }
        }
        if (dene == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null, "Bu İsimde Bir Kullanici Yoktur"));
        }
        em.getTransaction().commit();
        em.close();

    //    return "kullaniciEkle.xhtml?faces-redirect=true";
      
    }
 public boolean checkValidUser() {
        //selectRealAdmin();

        if (kullanici.getAd() != null ) {
            for (Kullanici real : kullanicilar) {
                if (kullanici.getAd().equals(real.getAd())) {


                    if (getMD5(kullanici.getSifre()).equals(real.getSifre())) {
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

    public boolean isIsSessionOpen() {
        return isSessionOpen;
    }
    private static boolean isSessionOpen;

    public static void setIsSessionOpen(boolean isSessionOpen) {
        KullaniciManaged.isSessionOpen = isSessionOpen;
    } 

     @Override
    public void afterPhase(PhaseEvent event) {
       FacesContext cont = event.getFacesContext();

        String page = cont.getViewRoot().getViewId();
        
        //gidilecek sayfanın ismi page değişkenine yüklendi
        
   setIsSessionOpen(checkValidUser());
   if(isIsSessionOpen()==false){
       

        if ((page.lastIndexOf("hosgeldin.xhtml") > -1)||(page.lastIndexOf("kullanici_ekle.xhtml") > -1)||(page.lastIndexOf("makaleler.xhtml") > -1)||(page.lastIndexOf("makaleDetailDialog.xhtml")>-1)||(page.lastIndexOf("index.xhtml")>-1)||(page.lastIndexOf("Duzenle.xhtml") > -1)||(page.lastIndexOf("EditComplete.xhtml")>-1)||(page.lastIndexOf("Sil.xhtml")>-1)) {
            
            KullaniciManaged.setIsSessionOpen(checkValidUser());
            if (isIsSessionOpen() == false) {
                 HttpSession session = (HttpSession) cont.getExternalContext().getSession(false);
                NavigationHandler nav = cont.getApplication().getNavigationHandler();
                nav.handleNavigation(cont, null, "ilk");
            
            }
   
}}
    }
    
     @Override
    public void beforePhase(PhaseEvent event) {
        boolean b;
        b = checkValidUser();
        setIsSessionOpen(b);
    }

    @Override 
    public PhaseId getPhaseId() {
       return PhaseId.RESTORE_VIEW;
    }
   
}
