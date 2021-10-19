package com.revature.foodinstagram.beans;

import javax.persistence.*;

@Entity
@Table(name = "comments", schema="Project-2")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "comment_posterid")
    private com.revature.foodinstagram.beans.User user;

    private String comment_header;
    private String comment_body;

    @ManyToOne
    @JoinColumn(name = "ref_postid")
    private com.revature.foodinstagram.beans.Post post;

    public Comment() {
    }

    public Comment(User user, String comment_header, String comment_body, Post post) {
        this.user = user;
        this.comment_header = comment_header;
        this.comment_body = comment_body;
        this.post = post;
    }

    public Comment(int id, User user, String comment_header, String comment_body, Post post) {
        this.id = id;
        this.user = user;
        this.comment_header = comment_header;
        this.comment_body = comment_body;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment_header() {
        return comment_header;
    }

    public void setComment_header(String comment_header) {
        this.comment_header = comment_header;
    }

    public String getComment_body() {
        return comment_body;
    }

    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", comment_header='" + comment_header + '\'' +
                ", commnet_body='" + comment_body + '\'' +
                ", post=" + post +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (user != null ? !user.equals(comment.user) : comment.user != null) return false;
        if (comment_header != null ? !comment_header.equals(comment.comment_header) : comment.comment_header != null)
            return false;
        if (comment_body != null ? !comment_body.equals(comment.comment_body) : comment.comment_body != null)
            return false;
        return post != null ? post.equals(comment.post) : comment.post == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (comment_header != null ? comment_header.hashCode() : 0);
        result = 31 * result + (comment_body != null ? comment_body.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        return result;
    }
}
