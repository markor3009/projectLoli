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
import javax.persistence.Lob;
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
@Table(name = "director")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d")})
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dir_id")
    private Integer dirId;
    @Size(max = 50)
    @Column(name = "dir_firstname")
    private String dirFirstname;
    @Size(max = 50)
    @Column(name = "dir_lastname")
    private String dirLastname;
    @Column(name = "dir_birthdate")
    @Temporal(TemporalType.DATE)
    private Date dirBirthdate;
    @Size(max = 255)
    @Column(name = "dir_country")
    private String dirCountry;
    @Lob
    @Size(max = 65535)
    @Column(name = "dir_biography")
    private String dirBiography;
    @OneToMany(mappedBy = "dirId")
    private List<Movie> movieList;
    @OneToMany(mappedBy = "dirId")
    private List<Photo> photoList;
    @OneToMany(mappedBy = "dirId")
    private List<UserDirector> userDirectorList;

    public Director() {
    }

    public Director(Integer dirId) {
        this.dirId = dirId;
    }

    public Integer getDirId() {
        return dirId;
    }

    public void setDirId(Integer dirId) {
        this.dirId = dirId;
    }

    public String getDirFirstname() {
        return dirFirstname;
    }

    public void setDirFirstname(String dirFirstname) {
        this.dirFirstname = dirFirstname;
    }

    public String getDirLastname() {
        return dirLastname;
    }

    public void setDirLastname(String dirLastname) {
        this.dirLastname = dirLastname;
    }

    public Date getDirBirthdate() {
        return dirBirthdate;
    }

    public void setDirBirthdate(Date dirBirthdate) {
        this.dirBirthdate = dirBirthdate;
    }

    public String getDirCountry() {
        return dirCountry;
    }

    public void setDirCountry(String dirCountry) {
        this.dirCountry = dirCountry;
    }

    public String getDirBiography() {
        return dirBiography;
    }

    public void setDirBiography(String dirBiography) {
        this.dirBiography = dirBiography;
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
    public List<UserDirector> getUserDirectorList() {
        return userDirectorList;
    }

    public void setUserDirectorList(List<UserDirector> userDirectorList) {
        this.userDirectorList = userDirectorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dirId != null ? dirId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.dirId == null && other.dirId != null) || (this.dirId != null && !this.dirId.equals(other.dirId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Director[ dirId=" + dirId + " ]";
    }
    
}
