package com.revature.foodinstagram.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "posterid")
    private com.revature.foodinstagram.beans.User user;

    private String title;
    private String body;
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "rec_rest_id")
    private com.revature.foodinstagram.beans.Restaurant restaurant;

    private Boolean recommend_rest;
    private Integer rating;

    public Post() {
    }

    public Post(User user, String title, String body, String image_url, Restaurant restaurant, Boolean recommend_rest, Integer rating) {
        this.user = user;
        this.title = title;
        this.body = body;
        this.image_url = image_url;
        this.restaurant = restaurant;
        this.recommend_rest = recommend_rest;
        this.rating = rating;
    }

    public Post(int id, User user, String title, String body, String image_url, Restaurant restaurant, Boolean recommend_rest, Integer rating) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
        this.image_url = image_url;
        this.restaurant = restaurant;
        this.recommend_rest = recommend_rest;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Boolean isRecommend_rest() {
        return recommend_rest;
    }

    public void setRecommend_rest(Boolean recommend_rest) {
        this.recommend_rest = recommend_rest;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", image_url='" + image_url + '\'' +
                ", restaurant=" + restaurant +
                ", recommend_rest=" + recommend_rest +
                ", rating=" + rating +
                '}';
    }

}
