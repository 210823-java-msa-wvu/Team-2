package com.revature.foodinstagram.beans;

import javax.persistence.*;

@Entity
@Table(name = "posts", schema="Project-2")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid")
    private int id;

    @ManyToOne
    @JoinColumn(name = "posterid")
    private com.revature.foodinstagram.beans.User user;

    private String title;
    private String body;
    private String rest_name;

    @ManyToOne
    @JoinColumn(name = "rec_rest_id")
    private com.revature.foodinstagram.beans.Restaurant restaurant;

    private boolean recommend_rest;
    private int rating;

    public Post() {
    }

    public Post(User user, String title, String body, String rest_name, Restaurant restaurant, boolean recommend_rest, int rating) {
        this.user = user;
        this.title = title;
        this.body = body;
        this.rest_name = rest_name;
        this.restaurant = restaurant;
        this.recommend_rest = recommend_rest;
        this.rating = rating;
    }

    public Post(int id, User user, String title, String body, String rest_name, Restaurant restaurant, boolean recommend_rest, int rating) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
        this.rest_name = rest_name;
        this.restaurant = restaurant;
        this.recommend_rest = recommend_rest;
        this.rating = rating;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isRecommend_rest() {
        return recommend_rest;
    }

    public void setRecommend_rest(boolean recommend_rest) {
        this.recommend_rest = recommend_rest;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", rest_name='" + rest_name + '\'' +
                ", restaurant=" + restaurant +
                ", recommend_rest=" + recommend_rest +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != post.id) return false;
        if (recommend_rest != post.recommend_rest) return false;
        if (rating != post.rating) return false;
        if (user != null ? !user.equals(post.user) : post.user != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (body != null ? !body.equals(post.body) : post.body != null) return false;
        if (rest_name != null ? !rest_name.equals(post.rest_name) : post.rest_name != null) return false;
        return restaurant != null ? restaurant.equals(post.restaurant) : post.restaurant == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (rest_name != null ? rest_name.hashCode() : 0);
        result = 31 * result + (restaurant != null ? restaurant.hashCode() : 0);
        result = 31 * result + (recommend_rest ? 1 : 0);
        result = 31 * result + rating;
        return result;
    }
}
