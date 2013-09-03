/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pakettoplam;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

@ManagedBean (name="toplama")
@RequestScoped
/**
 *
 * @author tugdev
 */
public class toplama {
    
    private int sayi1;
    private int sayi2;
    private int sonuc;
    
    public int getSayi1() {
return sayi1;
}
 
public void setSayi1(int sayi1) {
this.sayi1 = sayi1;
}
 

  public int getSayi2() {
return sayi2;
}
 
public void setSayi2(int sayi2) {
this.sayi2 = sayi2;
}
  public int getSonuc() {
return sonuc;
}
 
public void setSonuc(int sonuc) {
this.sonuc = sonuc;
}
//  public void Hesapla2(){
//sonuc=(sayi1+sayi2);
//System.out.println(sonuc);
//}    
  
 public void Hesapla(){
     sonuc=(sayi1+sayi2);
     System.out.println(sonuc);
     
        Session sess = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = sess.beginTransaction();
        Topla emp = new Topla();
        
                
        emp.setSayi1(sayi1);
        emp.setSayi2(sayi2);
        emp.setSonuc(sonuc);
        sess.save(emp);
        tr.commit();
        System.out.println("Başarıyla eklendi"); 
}   
    
    
    
    
    
    
    
    
    
}
