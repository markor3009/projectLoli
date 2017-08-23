/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p")})
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pht_id")
    private Integer phtId;
    @Size(max = 255)
    @Column(name = "pht_name")
    private String phtName;
    @Column(name = "pht_cover")
    private Short phtCover;
    @JoinColumn(name = "act_id", referencedColumnName = "act_id")
    @ManyToOne
    private Actor actId;
    @JoinColumn(name = "dir_id", referencedColumnName = "dir_id")
    @ManyToOne
    private Director dirId;
    @JoinColumn(name = "mov_id", referencedColumnName = "mov_id")
    @ManyToOne
    private Movie movId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private User usrId;

    public Photo() {
    }

    public Photo(Integer phtId) {
        this.phtId = phtId;
    }

    public Integer getPhtId() {
        return phtId;
    }

    public void setPhtId(Integer phtId) {
        this.phtId = phtId;
    }

    public String getPhtName() {
        return phtName;
    }

    public void setPhtName(String phtName) {
        this.phtName = phtName;
    }

    public Short getPhtCover() {
        return phtCover;
    }

    public void setPhtCover(Short phtCover) {
        this.phtCover = phtCover;
    }

    public Actor getActId() {
        return actId;
    }

    public void setActId(Actor actId) {
        this.actId = actId;
    }

    public Director getDirId() {
        return dirId;
    }

    public void setDirId(Director dirId) {
        this.dirId = dirId;
    }

    public Movie getMovId() {
        return movId;
    }

    public void setMovId(Movie movId) {
        this.movId = movId;
    }

    public User getUsrId() {
        return usrId;
    }

    public void setUsrId(User usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phtId != null ? phtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.phtId == null && other.phtId != null) || (this.phtId != null && !this.phtId.equals(other.phtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Photo[ phtId=" + phtId + " ]";
    }
    
}
