package com.example.springboot.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "country")
    private String country;

    public User() {
    }

    public User(String name, String lastName, String email, String country) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (id != user.id) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(lastName, user.lastName)) return false;
        if (!Objects.equals(email, user.email)) return false;

        return Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        int result = id;
        result += 31 * result + (name != null ? name.hashCode() : 0);
        result += 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result += 31 * result + (email != null ? email.hashCode() : 0);
        result += 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
