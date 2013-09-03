/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

/**
 *
 * @author SUMEYRA
 */
import com.kategori.Kategoriler;
import java.math.BigInteger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
    


@FacesConverter( value="kategoriConverter")
public  class KategoriConverter implements Converter {
EntityManagerFactory emf=
               Persistence.createEntityManagerFactory("KategorilerPU");
    private EntityManager em;
   
    
   private Kategoriler kategoriObje;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        
        
       if(string.equals(""))
           return null;
       
             em = emf.createEntityManager();
             em.getTransaction().begin();
             //   firmalar= (List<Firma>) em.createQuery("select i from Entity.Firma i where id=string").getResultList();
             kategoriObje=(Kategoriler) em.createQuery("select i from com.kategori.Kategoriler i where kategori_id=:kategori_id").setParameter("kategori_id",Long.parseLong(string)).getSingleResult();
             em.close();
             return kategoriObje;
    
    
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
        
    
        
        if(o instanceof Kategoriler)
            return ((Kategoriler)o).getKategoriId().toString();
        return "";
    
    }

   
}

    