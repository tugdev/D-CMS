/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pakettoplam;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author tugdev
 */
public class HesaplaBean {
    private List<toplama> islemler = new ArrayList<toplama>();
    private static String URL ="jdbc:mysql://localhost:3306/toplam?zeroDateTimeBehavior=convertToNull";
    private static String USERNAME="root";
    private static String PASSWORD ="";
    
    public HesaplaBean(){
     try{   
        Class.forName("com.mysql.jdbc.Driver"); //driverın ismi belirtilecek
        Connection con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
        PreparedStatement pst = con.prepareStatement("Select *from topla");
        ResultSet res = pst.executeQuery();
        
        while(res.next()){
            toplama hesap = new toplama();
            hesap.setSayi1(res.getInt("sayi1"));
            hesap.setSayi2(res.getInt("sayi2"));
            hesap.setSonuc(res.getInt("sonuc"));
            islemler.add(hesap);
        }
        
        res.close();
        pst.close();
        con.close();
     }catch(ClassNotFoundException c){
         
     }catch(SQLException s){
         
     }
    }
public List<toplama>getToplama(){
    return islemler;
}

public void setToplama(List<toplama> _islemler){
    this.islemler = _islemler;
}
    
    
    
    
    
    
    
    
    
}
