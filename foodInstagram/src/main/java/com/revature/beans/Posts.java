package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private int posterId;
    private String title;
    private String body;
    private String rest_name;
    private int rec_rest_id;
    private boolean recommend_rest;
    private int rating;

    public Posts() {
    }

    public Posts(Integer id, int posterId, String title, String body,
                 String rest_name, int rec_rest_id,
                 boolean reccomend_rest, int rating) {
        this.id = id;
        this.posterId = posterId;
        this.title = title;
        this.body = body;
        this.rest_name = rest_name;
        this.rec_rest_id = rec_rest_id;
        this.recommend_rest = recommend_rest;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public int getRec_rest_id() {
        return rec_rest_id;
    }

    public void setRec_rest_id(int rec_rest_id) {
        this.rec_rest_id = rec_rest_id;
    }

    public boolean isRecommend_rest() {
        return recommend_rest;
    }

    public void setRecommend_rest(boolean reccomend_rest) {
        this.recommend_rest = reccomend_rest;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", posterId=" + posterId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", rest_name='" + rest_name + '\'' +
                ", rec_rest_id=" + rec_rest_id +
                ", recommend_rest=" + recommend_rest +
                ", rating=" + rating +
                '}';
    }
}
