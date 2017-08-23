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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "user_movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMovie.findAll", query = "SELECT u FROM UserMovie u")})
public class UserMovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_mov_id")
    private Integer usrMovId;
    @JoinColumn(name = "mov_id", referencedColumnName = "mov_id")
    @ManyToOne
    private Movie movId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private User usrId;
    @JoinColumn(name = "rtp_id", referencedColumnName = "rtp_id")
    @ManyToOne
    private Relationshiptype rtpId;

    public UserMovie() {
    }

    public UserMovie(Integer usrMovId) {
        this.usrMovId = usrMovId;
    }

    public Integer getUsrMovId() {
        return usrMovId;
    }

    public void setUsrMovId(Integer usrMovId) {
        this.usrMovId = usrMovId;
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

    public Relationshiptype getRtpId() {
        return rtpId;
    }

    public void setRtpId(Relationshiptype rtpId) {
        this.rtpId = rtpId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrMovId != null ? usrMovId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMovie)) {
            return false;
        }
        UserMovie other = (UserMovie) object;
        if ((this.usrMovId == null && other.usrMovId != null) || (this.usrMovId != null && !this.usrMovId.equals(other.usrMovId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.UserMovie[ usrMovId=" + usrMovId + " ]";
    }
    
}
