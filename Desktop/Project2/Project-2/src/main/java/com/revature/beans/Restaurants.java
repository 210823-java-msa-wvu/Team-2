package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="restaurants")
public class Restaurants {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String rest_name;
    private String rest_location;
    private String rest_link;

    public Restaurants() {
    }

    public Restaurants(Integer id, String rest_name, String rest_location, String rest_link) {
        this.id = id;
        this.rest_name = rest_name;
        this.rest_location = rest_location;
        this.rest_link = rest_link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getRest_location() {
        return rest_location;
    }

    public void setRest_location(String rest_location) {
        this.rest_location = rest_location;
    }

    public String getRest_link() {
        return rest_link;
    }

    public void setRest_link(String rest_link) {
        this.rest_link = rest_link;
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "id=" + id +
                ", rest_name='" + rest_name + '\'' +
                ", rest_location='" + rest_location + '\'' +
                ", rest_link='" + rest_link + '\'' +
                '}';
    }
}
