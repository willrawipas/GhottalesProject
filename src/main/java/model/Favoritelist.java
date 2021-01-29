/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "favoritelist")
@NamedQueries({
    @NamedQuery(name = "Favoritelist.findAll", query = "SELECT f FROM Favoritelist f"),
    @NamedQuery(name = "Favoritelist.findByFavId", query = "SELECT f FROM Favoritelist f WHERE f.favId = :favId"),
    @NamedQuery(name = "Favoritelist.findByPostpostid", query = "SELECT f FROM Favoritelist f WHERE f.favoritelistPK.postpostid = :postpostid"),
    @NamedQuery(name = "Favoritelist.findByUserinfousername", query = "SELECT f FROM Favoritelist f WHERE f.favoritelistPK.userinfousername = :userinfousername")})
public class Favoritelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FavoritelistPK favoritelistPK;
    @Column(name = "fav_id")
    private Integer favId;
    @JoinColumn(name = "Post_post_id", referencedColumnName = "post_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Post post;
    @JoinColumn(name = "User_info_username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserInfo userInfo;

    public Favoritelist() {
    }

    public Favoritelist(FavoritelistPK favoritelistPK) {
        this.favoritelistPK = favoritelistPK;
    }

    public Favoritelist(int postpostid, String userinfousername) {
        this.favoritelistPK = new FavoritelistPK(postpostid, userinfousername);
    }

    public FavoritelistPK getFavoritelistPK() {
        return favoritelistPK;
    }

    public void setFavoritelistPK(FavoritelistPK favoritelistPK) {
        this.favoritelistPK = favoritelistPK;
    }

    public Integer getFavId() {
        return favId;
    }

    public void setFavId(Integer favId) {
        this.favId = favId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (favoritelistPK != null ? favoritelistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favoritelist)) {
            return false;
        }
        Favoritelist other = (Favoritelist) object;
        if ((this.favoritelistPK == null && other.favoritelistPK != null) || (this.favoritelistPK != null && !this.favoritelistPK.equals(other.favoritelistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Favoritelist[ favoritelistPK=" + favoritelistPK + " ]";
    }
    
}
