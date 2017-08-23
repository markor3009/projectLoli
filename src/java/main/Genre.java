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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "genre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g")})
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gnr_id")
    private Integer gnrId;
    @Size(max = 50)
    @Column(name = "gnr_name")
    private String gnrName;
    @JoinTable(name = "genre_user", joinColumns = {
        @JoinColumn(name = "gnr_id", referencedColumnName = "gnr_id")}, inverseJoinColumns = {
        @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")})
    @ManyToMany
    private List<User> userList;
    @JoinTable(name = "movie_genre", joinColumns = {
        @JoinColumn(name = "gnr_id", referencedColumnName = "gnr_id")}, inverseJoinColumns = {
        @JoinColumn(name = "mov_id", referencedColumnName = "mov_id")})
    @ManyToMany
    private List<Movie> movieList;

    public Genre() {
    }

    public Genre(Integer gnrId) {
        this.gnrId = gnrId;
    }

    public Integer getGnrId() {
        return gnrId;
    }

    public void setGnrId(Integer gnrId) {
        this.gnrId = gnrId;
    }

    public String getGnrName() {
        return gnrName;
    }

    public void setGnrName(String gnrName) {
        this.gnrName = gnrName;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gnrId != null ? gnrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.gnrId == null && other.gnrId != null) || (this.gnrId != null && !this.gnrId.equals(other.gnrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Genre[ gnrId=" + gnrId + " ]";
    }
    
}
