/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "relationshiptype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relationshiptype.findAll", query = "SELECT r FROM Relationshiptype r")})
public class Relationshiptype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rtp_id")
    private Integer rtpId;
    @Size(max = 45)
    @Column(name = "rtp_name")
    private String rtpName;
    @OneToMany(mappedBy = "rtpId")
    private List<UserMovie> userMovieList;
    @OneToMany(mappedBy = "rtpId")
    private List<UserActor> userActorList;
    @OneToMany(mappedBy = "rtpId")
    private List<UserDirector> userDirectorList;

    public Relationshiptype() {
    }

    public Relationshiptype(Integer rtpId) {
        this.rtpId = rtpId;
    }

    public Integer getRtpId() {
        return rtpId;
    }

    public void setRtpId(Integer rtpId) {
        this.rtpId = rtpId;
    }

    public String getRtpName() {
        return rtpName;
    }

    public void setRtpName(String rtpName) {
        this.rtpName = rtpName;
    }

    @XmlTransient
    public List<UserMovie> getUserMovieList() {
        return userMovieList;
    }

    public void setUserMovieList(List<UserMovie> userMovieList) {
        this.userMovieList = userMovieList;
    }

    @XmlTransient
    public List<UserActor> getUserActorList() {
        return userActorList;
    }

    public void setUserActorList(List<UserActor> userActorList) {
        this.userActorList = userActorList;
    }

    @XmlTransient
    public List<UserDirector> getUserDirectorList() {
        return userDirectorList;
    }

    public void setUserDirectorList(List<UserDirector> userDirectorList) {
        this.userDirectorList = userDirectorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rtpId != null ? rtpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relationshiptype)) {
            return false;
        }
        Relationshiptype other = (Relationshiptype) object;
        if ((this.rtpId == null && other.rtpId != null) || (this.rtpId != null && !this.rtpId.equals(other.rtpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Relationshiptype[ rtpId=" + rtpId + " ]";
    }
    
}
