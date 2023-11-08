package com.allandroidprojects.ecomsample.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private String email;
    private String fullname;
    private String username;
    private String password;
    private String cartItemIdComma;

    public User() {
    }

    public User(String email, String fullname, String username, String password, String cartItemIdComma) {
        this.email = email;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.cartItemIdComma = cartItemIdComma;
    }

    public User(String email, String fullname, String username, String password) {
        this.email = email;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String cartItemIdComma) {
        this.username = username;
        this.password = password;
        this.cartItemIdComma = cartItemIdComma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCartItemIdComma() {
        return cartItemIdComma;
    }

    public void setCartItemIdComma(String cartItemIdComma) {
        this.cartItemIdComma = cartItemIdComma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
