package com.kategori;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ubuntu
 */
@Entity
@Table(name = "kategoriler")
@NamedQueries({
    @NamedQuery(name = "Kategoriler.findAll", query = "SELECT k FROM Kategoriler k"),
    @NamedQuery(name = "Kategoriler.findByKategoriId", query = "SELECT k FROM Kategoriler k WHERE k.kategoriId = :kategoriId"),
    @NamedQuery(name = "Kategoriler.findByKategoriAdi", query = "SELECT k FROM Kategoriler k WHERE k.kategoriAdi = :kategoriAdi"),
    @NamedQuery(name = "Kategoriler.findByKatUstId", query = "SELECT k FROM Kategoriler k WHERE k.katUstId = :katUstId")})
public class Kategoriler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kategori_id")
    private Integer kategoriId;
    @Basic(optional = false)
    @Column(name = "kategori_adi")
    private String kategoriAdi;
    @Column(name = "kat_ust_id")
    private Integer katUstId;
    
    public Kategoriler() {
    }

    public Kategoriler(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public Kategoriler(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public Kategoriler(Integer kategoriId, String kategoriAdi) {
        this.kategoriId = kategoriId;
        this.kategoriAdi = kategoriAdi;
    }

    public Kategoriler(String kategoriAdi, Integer katUstId) {
        this.kategoriAdi = kategoriAdi;
        this.katUstId = katUstId;
    }

    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Integer kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public Integer getKatUstId() {
        return katUstId;
    }

    public void setKatUstId(Integer katUstId) {
        this.katUstId = katUstId;
    }

   
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategoriId != null ? kategoriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategoriler)) {
            return false;
        }
        Kategoriler other = (Kategoriler) object;
        if ((this.kategoriId == null && other.kategoriId != null) || (this.kategoriId != null && !this.kategoriId.equals(other.kategoriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kategori.Kategoriler[kategoriId=" + kategoriId + "]";
    }

}
