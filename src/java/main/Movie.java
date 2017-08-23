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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mov_id")
    private Integer movId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mov_title")
    private String movTitle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mov_duration")
    private Double movDuration;
    @Lob
    @Size(max = 65535)
    @Column(name = "mov_description")
    private String movDescription;
    @Size(max = 255)
    @Column(name = "mov_country")
    private String movCountry;
    @Column(name = "mov_year")
    @Temporal(TemporalType.DATE)
    private Date movYear;
    @Column(name = "mov_likes")
    private Integer movLikes;
    @Column(name = "mov_shown")
    private Integer movShown;
    @Column(name = "mov_imdbrating")
    private Double movImdbrating;
    @ManyToMany(mappedBy = "movieList")
    private List<Actor> actorList;
    @ManyToMany(mappedBy = "movieList")
    private List<Genre> genreList;
    @OneToMany(mappedBy = "movId")
    private List<UserMovie> userMovieList;
    @JoinColumn(name = "dir_id", referencedColumnName = "dir_id")
    @ManyToOne
    private Director dirId;
    @OneToMany(mappedBy = "movId")
    private List<Photo> photoList;

    public Movie() {
    }

    public Movie(Integer movId) {
        this.movId = movId;
    }

    public Movie(Integer movId, String movTitle) {
        this.movId = movId;
        this.movTitle = movTitle;
    }

    public Integer getMovId() {
        return movId;
    }

    public void setMovId(Integer movId) {
        this.movId = movId;
    }

    public String getMovTitle() {
        return movTitle;
    }

    public void setMovTitle(String movTitle) {
        this.movTitle = movTitle;
    }

    public Double getMovDuration() {
        return movDuration;
    }

    public void setMovDuration(Double movDuration) {
        this.movDuration = movDuration;
    }

    public String getMovDescription() {
        return movDescription;
    }

    public void setMovDescription(String movDescription) {
        this.movDescription = movDescription;
    }

    public String getMovCountry() {
        return movCountry;
    }

    public void setMovCountry(String movCountry) {
        this.movCountry = movCountry;
    }

    public Date getMovYear() {
        return movYear;
    }

    public void setMovYear(Date movYear) {
        this.movYear = movYear;
    }

    public Integer getMovLikes() {
        return movLikes;
    }

    public void setMovLikes(Integer movLikes) {
        this.movLikes = movLikes;
    }

    public Integer getMovShown() {
        return movShown;
    }

    public void setMovShown(Integer movShown) {
        this.movShown = movShown;
    }

    public Double getMovImdbrating() {
        return movImdbrating;
    }

    public void setMovImdbrating(Double movImdbrating) {
        this.movImdbrating = movImdbrating;
    }

    @XmlTransient
    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
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

    public Director getDirId() {
        return dirId;
    }

    public void setDirId(Director dirId) {
        this.dirId = dirId;
    }

    @XmlTransient
    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movId != null ? movId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movId == null && other.movId != null) || (this.movId != null && !this.movId.equals(other.movId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Movie[ movId=" + movId + " ]";
    }
    
}
