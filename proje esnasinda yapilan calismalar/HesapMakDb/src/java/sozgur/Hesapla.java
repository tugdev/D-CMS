/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sozgur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 *
 * @author sozgur
 */
@ManagedBean(name="Hesapla")
@RequestScoped
public class Hesapla {

     private float sayi1;
     private float sayi2;
     private float sonuc;
   
     

    public float getSayi1() {
        return sayi1;
    }

    public void setSayi1(float sayi1) {
        this.sayi1 = sayi1;
    }

    public float getSayi2() {
        return sayi2;
    }

    public void setSayi2(float sayi2) {
        this.sayi2 = sayi2;
    }

    public float getSonuc() {
        return sonuc;
    }

    public void setSonuc(float sonuc) {
        this.sonuc = sonuc;
    }
     
        
    public void Topla() {
        sonuc=(sayi1+sayi2);
        System.out.println(sonuc);
        
        Session sess = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = sess.beginTransaction();
        Kaydet emp = new Kaydet(); 
        emp.setSayi1(sayi1);
        emp.setSayi2(sayi2);
        emp.setSonuc(sonuc);
        sess.save(emp);
        tr.commit();
       
}  
 
   
}
