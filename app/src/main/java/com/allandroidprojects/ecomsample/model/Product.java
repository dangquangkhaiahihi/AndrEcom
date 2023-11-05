package com.allandroidprojects.ecomsample.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Product {
    @PrimaryKey
    private int id;

    private String name;
    private String desc;
    private String price;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static void setWishList(ArrayList<Product> wishList) {
        Product.wishList = wishList;
    }

    public static void setCartList(ArrayList<Product> cartList) {
        Product.cartList = cartList;
    }

    private String phone;

    static ArrayList<Product> wishList = new ArrayList<>();
    static ArrayList<Product> cartList = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String desc, String price, String url, String phone) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.imageUrl = url;
        this.phone = phone;
    }

    // getter methods
    public String getItemName() {
        return name;
    }

    public String getItemDesc() {
        return desc;
    }

    public String getItemPrice() {
        return price;
    }

    public String getItemImageUrl() {
        return imageUrl;
    }

    public static ArrayList<Product> getWishList() {
        return wishList;
    }

    public void setWishList(Product product) {
        this.wishList.add(0, product);
    }

    public static ArrayList<Product> getCartList() {
        return cartList;
    }

    public void setCartList(Product product) {
        this.cartList.add(0, product);
    }

    public void removeFromCart(int position)
    {
        this.cartList.remove(position);
    }

    public void removeWishList(int position)
    {
        this.wishList.remove(position);
    }

// setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public void setItemDesc(String desc) {
        this.desc = desc;
    }

    public void setItemPrice(String price) {
        this.price = price;
    }
    public void setItemImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
