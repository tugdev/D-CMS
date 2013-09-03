/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toplama;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean (name="toplam")
@RequestScoped
/**
 *
 * @author tugdev
 */
public class toplam {
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
    
 public void Hesapla(){
sonuc=(sayi1+sayi2);
System.out.println(sonuc);
}   
    
    
    
    
    
}
