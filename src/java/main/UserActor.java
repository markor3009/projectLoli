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
@Table(name = "user_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserActor.findAll", query = "SELECT u FROM UserActor u")})
public class UserActor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_act_id")
    private Integer usrActId;
    @JoinColumn(name = "rtp_id", referencedColumnName = "rtp_id")
    @ManyToOne
    private Relationshiptype rtpId;
    @JoinColumn(name = "act_id", referencedColumnName = "act_id")
    @ManyToOne
    private Actor actId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private User usrId;

    public UserActor() {
    }

    public UserActor(Integer usrActId) {
        this.usrActId = usrActId;
    }

    public Integer getUsrActId() {
        return usrActId;
    }

    public void setUsrActId(Integer usrActId) {
        this.usrActId = usrActId;
    }

    public Relationshiptype getRtpId() {
        return rtpId;
    }

    public void setRtpId(Relationshiptype rtpId) {
        this.rtpId = rtpId;
    }

    public Actor getActId() {
        return actId;
    }

    public void setActId(Actor actId) {
        this.actId = actId;
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
        hash += (usrActId != null ? usrActId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserActor)) {
            return false;
        }
        UserActor other = (UserActor) object;
        if ((this.usrActId == null && other.usrActId != null) || (this.usrActId != null && !this.usrActId.equals(other.usrActId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.UserActor[ usrActId=" + usrActId + " ]";
    }
    
}
