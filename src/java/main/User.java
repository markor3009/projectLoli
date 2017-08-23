/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_id")
    private Integer usrId;
    @Size(max = 45)
    @Column(name = "usr_username")
    private String usrUsername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_email")
    private String usrEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr_password")
    private String usrPassword;
    @Size(max = 50)
    @Column(name = "usr_firstname")
    private String usrFirstname;
    @Size(max = 50)
    @Column(name = "usr_lastname")
    private String usrLastname;
    @Column(name = "usr_birthdate")
    @Temporal(TemporalType.DATE)
    private Date usrBirthdate;
    @Column(name = "usr_admin")
    private Short usrAdmin;
    @Column(name = "usr_gender")
    private Short usrGender;
    @ManyToMany(mappedBy = "userList")
    private List<Genre> genreList;
    @OneToMany(mappedBy = "usrId")
    private List<UserMovie> userMovieList;
    @OneToMany(mappedBy = "usrId")
    private List<Photo> photoList;
    @OneToMany(mappedBy = "usrId")
    private List<UserActor> userActorList;
    @OneToMany(mappedBy = "usrId")
    private List<UserDirector> userDirectorList;

    public User() {
    }

    public User(Integer usrId) {
        this.usrId = usrId;
    }

    public User(Integer usrId, String usrEmail, String usrPassword) {
        this.usrId = usrId;
        this.usrEmail = usrEmail;
        this.usrPassword = usrPassword;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrUsername() {
        return usrUsername;
    }

    public void setUsrUsername(String usrUsername) {
        this.usrUsername = usrUsername;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getUsrFirstname() {
        return usrFirstname;
    }

    public void setUsrFirstname(String usrFirstname) {
        this.usrFirstname = usrFirstname;
    }

    public String getUsrLastname() {
        return usrLastname;
    }

    public void setUsrLastname(String usrLastname) {
        this.usrLastname = usrLastname;
    }

    public Date getUsrBirthdate() {
        return usrBirthdate;
    }

    public void setUsrBirthdate(Date usrBirthdate) {
        this.usrBirthdate = usrBirthdate;
    }

    public Short getUsrAdmin() {
        return usrAdmin;
    }

    public void setUsrAdmin(Short usrAdmin) {
        this.usrAdmin = usrAdmin;
    }

    public Short getUsrGender() {
        return usrGender;
    }

    public void setUsrGender(Short usrGender) {
        this.usrGender = usrGender;
    }

    @XmlTransient
    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    @XmlTransient
    public List<UserMovie> getUserMovieList() {
        return userMovieList;
    }

    public void setUserMovieList(List<UserMovie> userMovieList) {
        this.userMovieList = userMovieList;
    }

    @XmlTransient
    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
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
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.User[ usrId=" + usrId + " ]";
    }
    
}
