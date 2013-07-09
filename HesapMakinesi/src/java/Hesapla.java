import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean (name="Hesapla")
@RequestScoped

 

public class Hesapla { 
     private float sayı1;
     private float sayı2;
     private float sonuc;


    public float getSayı1() {
        return sayı1;
    }

    public void setSayı1(float sayı1) {
        this.sayı1 = sayı1;
    }

    public float getSayı2() {
        return sayı2;
    }

    public void setSayı2(float sayı2) {
        this.sayı2 = sayı2;
    }

    public float getSonuc() {
        return sonuc;
    }

    public void setSonuc(float sonuc) {
        this.sonuc = sonuc;
    }
     
     

        
    public void Topla(){
        sonuc=(sayı1+sayı2);
        System.out.println(sonuc);
}  
      public void Çıkar(){
        sonuc=(sayı1-sayı2);
        System.out.println(sonuc);
}
         public void Böl(){
        sonuc=(sayı1/sayı2);
        System.out.println(sonuc);
}
            public void Çarp(){
        sonuc=(sayı1*sayı2);
        System.out.println(sonuc);
}
}
