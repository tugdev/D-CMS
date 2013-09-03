package sorugu;

import org.hibernate.Session;
import pakettoplam.NewHibernateUtil;
import pakettoplam.Topla;



/**
 *
 * @author tugdev
 */
public class Sorgu {
    public static void main(String[] args){
       int sayiid=1;
       int a;
       int b;
       int c;
       
       Session sess = NewHibernateUtil.getSessionFactory().openSession();
       Topla per=(Topla)sess.get(Topla.class,sayiid);
       a=per.getSayi1();
       b=per.getSayi2();
       c=per.getSonuc();
       System.out.println("sayi1 :"+a);
//        System.out.println("sayi1 :"+per.getSayi1());
//        System.out.println("sayi2 :"+per.getSayi2());
//        System.out.println("sonuc :"+per.getSonuc());
        
        
    }
}
