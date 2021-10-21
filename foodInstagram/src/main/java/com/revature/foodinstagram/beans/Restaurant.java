package com.revature.foodinstagram.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "restaurants", schema="Project2")
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rest_id;
    private String rest_name;
    private String rest_location;
    private String rest_link;

    public Restaurant() {
    }

    public Restaurant(String rest_name, String rest_location, String rest_link) {
        this.rest_name = rest_name;
        this.rest_location = rest_location;
        this.rest_link = rest_link;
    }

    public Restaurant(int rest_id, String rest_name, String rest_location, String rest_link) {
        this.rest_id = rest_id;
        this.rest_name = rest_name;
        this.rest_location = rest_location;
        this.rest_link = rest_link;
    }

    public int getRest_id() {
        return rest_id;
    }

    public void setRest_id(int rest_id) {
        this.rest_id = rest_id;
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
        return "Restaurant{" +
                "rest_id=" + rest_id +
                ", rest_name='" + rest_name + '\'' +
                ", rest_location='" + rest_location + '\'' +
                ", rest_link='" + rest_link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (rest_id != that.rest_id) return false;
        if (rest_name != null ? !rest_name.equals(that.rest_name) : that.rest_name != null) return false;
        if (rest_location != null ? !rest_location.equals(that.rest_location) : that.rest_location != null)
            return false;
        return rest_link != null ? rest_link.equals(that.rest_link) : that.rest_link == null;
    }

    @Override
    public int hashCode() {
        int result = rest_id;
        result = 31 * result + (rest_name != null ? rest_name.hashCode() : 0);
        result = 31 * result + (rest_location != null ? rest_location.hashCode() : 0);
        result = 31 * result + (rest_link != null ? rest_link.hashCode() : 0);
        return result;
    }
}
