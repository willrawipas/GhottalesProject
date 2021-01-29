/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author User
 */
@Embeddable
public class CommentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_id")
    private int commentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Post_post_id")
    private int postpostid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "User_info_username")
    private String userinfousername;

    public CommentPK() {
    }

    public CommentPK(int commentId, String comment, Date createTime, int postpostid, String userinfousername) {
        this.commentId = commentId;
        this.comment = comment;
        this.createTime = createTime;
        this.postpostid = postpostid;
        this.userinfousername = userinfousername;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        hash += (int) commentId;
        hash += (comment != null ? comment.hashCode() : 0);
        hash += (createTime != null ? createTime.hashCode() : 0);
        hash += (int) postpostid;
        hash += (userinfousername != null ? userinfousername.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentPK)) {
            return false;
        }
        CommentPK other = (CommentPK) object;
        if (this.commentId != other.commentId) {
            return false;
        }
        if ((this.comment == null && other.comment != null) || (this.comment != null && !this.comment.equals(other.comment))) {
            return false;
        }
        if ((this.createTime == null && other.createTime != null) || (this.createTime != null && !this.createTime.equals(other.createTime))) {
            return false;
        }
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
        return "model.CommentPK[ commentId=" + commentId + ", comment=" + comment + ", createTime=" + createTime + ", postpostid=" + postpostid + ", userinfousername=" + userinfousername + " ]";
    }
    
}
