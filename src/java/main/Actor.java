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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a")})
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "act_id")
    private Integer actId;
    @Size(max = 50)
    @Column(name = "act_firstname")
    private String actFirstname;
    @Size(max = 50)
    @Column(name = "act_lastname")
    private String actLastname;
    @Column(name = "act_birthdate")
    @Temporal(TemporalType.DATE)
    private Date actBirthdate;
    @Size(max = 50)
    @Column(name = "act_country")
    private String actCountry;
    @Lob
    @Size(max = 65535)
    @Column(name = "act_biography")
    private String actBiography;
    @Column(name = "act_gender")
    private Short actGender;
    @JoinTable(name = "movie_actor", joinColumns = {
        @JoinColumn(name = "act_id", referencedColumnName = "act_id")}, inverseJoinColumns = {
        @JoinColumn(name = "mov_id", referencedColumnName = "mov_id")})
    @ManyToMany
    private List<Movie> movieList;
    @OneToMany(mappedBy = "actId")
    private List<Photo> photoList;
    @OneToMany(mappedBy = "actId")
    private List<UserActor> userActorList;

    public Actor() {
    }

    public Actor(Integer actId) {
        this.actId = actId;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getActFirstname() {
        return actFirstname;
    }

    public void setActFirstname(String actFirstname) {
        this.actFirstname = actFirstname;
    }

    public String getActLastname() {
        return actLastname;
    }

    public void setActLastname(String actLastname) {
        this.actLastname = actLastname;
    }

    public Date getActBirthdate() {
        return actBirthdate;
    }

    public void setActBirthdate(Date actBirthdate) {
        this.actBirthdate = actBirthdate;
    }

    public String getActCountry() {
        return actCountry;
    }

    public void setActCountry(String actCountry) {
        this.actCountry = actCountry;
    }

    public String getActBiography() {
        return actBiography;
    }

    public void setActBiography(String actBiography) {
        this.actBiography = actBiography;
    }

    public Short getActGender() {
        return actGender;
    }

    public void setActGender(Short actGender) {
        this.actGender = actGender;
    }

    @XmlTransient
    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Actor[ actId=" + actId + " ]";
    }
    
}
