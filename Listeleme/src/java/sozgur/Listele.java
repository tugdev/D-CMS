/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sozgur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import sozgur.Hesapla;



                  
    public class Listele implements Serializable {  
           
       private Hesapla hesapla;     
   
   
    
 
           
        
    private void getSayi1() {  
        System.out.println(hesapla.getListe()); 
    }  
      
    
}  


