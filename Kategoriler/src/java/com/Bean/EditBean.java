package com.Bean;

import com.kategori.Kategoriler;
import com.kategori.KategorilerJpaController;
import com.kategori.Makale;
import com.kategori.exceptions.NonexistentEntityException;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author ubuntu
 */
public class EditBean {
    private Makale makale;
    private KategorilerJpaController contObje;
    private Kategoriler kategoriObje;
    private List<Kategoriler> allRecordList;
    private List<Makale> makaleler;

    public List<Makale> getMakaleler() {
        return makaleler;
    }

    public void setMakaleler(List<Makale> makaleler) {
        this.makaleler = makaleler;
    }

    
    public Makale getMakale() {
        return makale;
    }

    public void setMakale(Makale makale) {
        this.makale = makale;
    }
    
    

    public List<Kategoriler> getAllRecordList() {
        return allRecordList;
    }
    public Kategoriler getKategoriObje() {
        return kategoriObje;
    }
    public void setKategoriObje(Kategoriler kategoriObje) {
        this.kategoriObje = kategoriObje;
    }
    public void setAllRecordList(List<Kategoriler> allRecordList) {
        this.allRecordList = allRecordList;
    }
    
    public EditBean() {
        contObje=new KategorilerJpaController();
        allRecordList=contObje.findKategorilerEntities();
        kategoriObje=new Kategoriler();
//Request nesnesi olusturup <h:outputLink> ile
//<f:param name="id" value="#{items.kategoriId}"/> degeri aliniyor
        FacesContext context=FacesContext.getCurrentInstance();
        HttpServletRequest request=(HttpServletRequest) context.getExternalContext().getRequest();
        if(request.getParameter("id")!=null){
            int katId=Integer.parseInt(request.getParameter("id"));
            kategoriObje=contObje.findKategoriler(katId);
        }
    }
    public void editCpmlete() throws NonexistentEntityException, Exception{
//<h:selectOneMenu value="#{editBean.kategoriObje.katUstId}"> ta ust kategori secilir ve
//<h:inputText value="#{editBean.kategoriObje.kategoriAdi}" required="true"/> alanina da kategori ismi duzenlenir
//secilen deger ve kategori adi edi() hazir medotu ile guncellenir bilgiler. Bu da kategorId primarykey iel guncellenir.
        contObje.edit(kategoriObje);
    }
//reset ile nesneye null deger atadim.
    public void reset(){
        getKategoriObje().setKatUstId(null);
        getKategoriObje().setKategoriAdi(null);
        getKategoriObje().setKategoriId(null);
    }
}
