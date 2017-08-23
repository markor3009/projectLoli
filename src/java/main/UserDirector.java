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
@Table(name = "user_director")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDirector.findAll", query = "SELECT u FROM UserDirector u")})
public class UserDirector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_dir_id")
    private Integer usrDirId;
    @JoinColumn(name = "rtp_id", referencedColumnName = "rtp_id")
    @ManyToOne
    private Relationshiptype rtpId;
    @JoinColumn(name = "dir_id", referencedColumnName = "dir_id")
    @ManyToOne
    private Director dirId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private User usrId;

    public UserDirector() {
    }

    public UserDirector(Integer usrDirId) {
        this.usrDirId = usrDirId;
    }

    public Integer getUsrDirId() {
        return usrDirId;
    }

    public void setUsrDirId(Integer usrDirId) {
        this.usrDirId = usrDirId;
    }

    public Relationshiptype getRtpId() {
        return rtpId;
    }

    public void setRtpId(Relationshiptype rtpId) {
        this.rtpId = rtpId;
    }

    public Director getDirId() {
        return dirId;
    }

    public void setDirId(Director dirId) {
        this.dirId = dirId;
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
        hash += (usrDirId != null ? usrDirId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDirector)) {
            return false;
        }
        UserDirector other = (UserDirector) object;
        if ((this.usrDirId == null && other.usrDirId != null) || (this.usrDirId != null && !this.usrDirId.equals(other.usrDirId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.UserDirector[ usrDirId=" + usrDirId + " ]";
    }
    
}
