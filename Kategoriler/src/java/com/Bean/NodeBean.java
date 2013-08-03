/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Bean;


import com.kategori.Dialog;
import com.kategori.Kategoriler;
import com.kategori.KategorilerJpaController;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import javax.faces.context.FacesContext;  


/**
 *
 * @author ubuntu
 */
public class NodeBean {

    private TreeNode root;
    private TreeNode donanim;
    private TreeNode selectedNode;
    private static  List<Kategoriler> liste;
    private static List<Kategoriler> araListe;
    private KategorilerJpaController katCont;
    private Kategoriler katNesnesi;
    private List<Kategoriler> subList2;
    private String kategIsmi;
    
   
    private Kategoriler kat = new Kategoriler();

    public Kategoriler getKat() {
        return kat;
    }

    public void setKat(Kategoriler kat) {
        this.kat = kat;
    }
    
   

   
            
    public NodeBean() {
        liste=new ArrayList<Kategoriler>();
        root=new DefaultTreeNode("Root",null);
        katCont=new KategorilerJpaController();
        liste=katCont.findKategorilerEntities();
        donanim=new DefaultTreeNode("", root);
//Butun kategorileri tutan bir ana kategori olusturuyor.
//Dynamic olarak sub kategori ekliyor. Recursive olarak hepsini kontrol edilmesi lazim.
        recursive(liste, 0,donanim);

    }
//Dynamic tree viewi olutruan method.
    public  void recursive(List<Kategoriler> liste, int id,TreeNode node){
            subList2=new ArrayList<Kategoriler>();
            subList2=subKategori(id);
          for(Kategoriler k:subList2){
            TreeNode childNode=new DefaultTreeNode(k.getKategoriAdi(), node);
//Veritabaninda kategori tablosunu tree view seklinde dynamic olarak olusturmayi saglar.
             recursive(subList2, k.getKategoriId(),childNode);
          }

    }
//herhangi bir tree nodenin childlarini buluyor.
    public static List<Kategoriler> subKategori(int i)
    {
        araListe=new ArrayList<Kategoriler>();
        for(Kategoriler k:getListe()){
            if(k.getKatUstId()==i){
                araListe.add(k);
            }
        }
        return araListe;
    }
    public static List<Kategoriler> getListe() {
        return liste;
    }
    public Kategoriler getKatNesnesi() {
        return katNesnesi;
    }
    public void setKatNesnesi(Kategoriler katNesnesi) {
        this.katNesnesi = katNesnesi;
    }
    public TreeNode getRoot() {
        return root;
    }
    
    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    public void secilenNode(NodeSelectEvent event){
        FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "selected", event.getTreeNode().getData().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   
    public String getKategIsmi() {
        return kategIsmi;
    }

    public void setKategIsmi(String kategIsmi) {
        this.kategIsmi = kategIsmi;
    }


    public void yeniKatEkle(){
//      JOptionPane.showMessageDialog(null,katCont.kategoriIdDonder(getSelectedNode().getData().toString()).getKategoriId());
        katNesnesi=new Kategoriler(getKategIsmi(), katCont.kategoriIdDonder(getSelectedNode().getData().toString()).getKategoriId());
        katCont.create(katNesnesi);
        setKategIsmi(null);
    }
    
     public void sil() throws NoSuchAlgorithmException { //veritabanımıza Delete işlemlerinin gerçekleştirildiği fonksiyon     
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
    EntityManager em = emf.createEntityManager();
    
    if(kat.getKategoriId()==1){
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kategoriler Başılığı Silinemez!", null);   
//        FacesContext.getCurrentInstance().addMessage(null, message);  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null, "Bilgilendirme:Kategoriler Başılığı Silinemez!"));
        
    }
    else{
    kat = em.find(kat.getClass(), kat.getKategoriId()); 
    //em.find ile veritabanımızdaki verdiğimiz id numarasını içeren kayıtı bulup üst tarafta 
    //tanımladığım kat adlı nesnemize atıyoruz.
    em.getTransaction().begin();
    em.remove(this.kat);
    em.getTransaction().commit(); 
    em.close();
    }
    
     } 
    
    public void duzenle() throws NoSuchAlgorithmException { //veritabanımıza Delete işlemlerinin gerçekleştirildiği fonksiyon     
        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("KategorilerPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Kategoriler katx=em.find(kat.getClass(), kat.getKategoriId());
            katx.setKategoriAdi(kat.getKategoriAdi());
            em.getTransaction().commit();
            em.close();
            emf.close();
  
 
}
}

