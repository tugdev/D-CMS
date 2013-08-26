/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kategori;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Kullanici implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ad;
    private String sifre;
    private String rol;
    private Integer akpa;
    public static final String AUTH_KEY = "ad";

    public Integer getAkpa() {
        return akpa;
    }

    public void setAkpa(Integer akpa) {
        this.akpa = akpa;
    }
    
    
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kategori.Kullanici[ id=" + id + " ]";
    }
    
    boolean isLoggedIn() {
          return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(AUTH_KEY) != null;
    }
    
    public String login() {
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, ad);
             return "true";
    }
    
    public String logout() {
           FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_KEY);
          return null;
    }
}
