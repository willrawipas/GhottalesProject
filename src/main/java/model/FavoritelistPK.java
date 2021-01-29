/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Embeddable
public class FavoritelistPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Post_post_id")
    private int postpostid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "User_info_username")
    private String userinfousername;

    public FavoritelistPK() {
    }

    public FavoritelistPK(int postpostid, String userinfousername) {
        this.postpostid = postpostid;
        this.userinfousername = userinfousername;
    }

    public int getPostpostid() {
        return postpostid;
    }

    public void setPostpostid(int postpostid) {
        this.postpostid = postpostid;
    }

    public String getUserinfousername() {
        return userinfousername;
    }

    public void setUserinfousername(String userinfousername) {
        this.userinfousername = userinfousername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) postpostid;
        hash += (userinfousername != null ? userinfousername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FavoritelistPK)) {
            return false;
        }
        FavoritelistPK other = (FavoritelistPK) object;
        if (this.postpostid != other.postpostid) {
            return false;
        }
        if ((this.userinfousername == null && other.userinfousername != null) || (this.userinfousername != null && !this.userinfousername.equals(other.userinfousername))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FavoritelistPK[ postpostid=" + postpostid + ", userinfousername=" + userinfousername + " ]";
    }
    
}
