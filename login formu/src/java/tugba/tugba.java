/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tugba;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tugdev
 */
@Entity
public class tugba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ad1;
    private String sy1;
    private int ys1;
    
    
    
    
    
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
        if (!(object instanceof tugba)) {
            return false;
        }
        tugba other = (tugba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugba.tugba[ id=" + id + " ]";
    }

    public String getAd1() {
        return ad1;
    }

    public void setAd1(String ad1) {
        this.ad1 = ad1;
    }

    public String getSy1() {
        return sy1;
    }

    public void setSy1(String sy1) {
        this.sy1 = sy1;
    }

    public int getYs1() {
        return ys1;
    }

    public void setYs1(int ys1) {
        this.ys1 = ys1;
    }
    
}
