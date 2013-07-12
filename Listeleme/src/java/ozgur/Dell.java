/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ozgur;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author sozgur
 */
@Entity
public class Dell implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double sy1;
    private double sy2;
    private double tplm;

    public double getSy1() {
        return sy1;
    }

    public void setSy1(double sy1) {
        this.sy1 = sy1;
    }

    public double getSy2() {
        return sy2;
    }

    public void setSy2(double sy2) {
        this.sy2 = sy2;
    }

    public double getTplm() {
        return tplm;
    }

    public void setTplm(double tplm) {
        this.tplm = tplm;
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
        if (!(object instanceof Dell)) {
            return false;
        }
        Dell other = (Dell) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ozgur.AAAAA[ id=" + id + " ]";
    }
    
}
