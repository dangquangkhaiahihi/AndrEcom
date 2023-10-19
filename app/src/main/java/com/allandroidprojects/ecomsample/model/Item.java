package com.allandroidprojects.ecomsample.model;

public class Item {

    private String name;
    private String desc;
    private String price;
    private int image;
    private String imageUrl;
    private String phone;

    public Item(String name, String desc, String price, int imageid, String url, String phone)
    {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.image = imageid;
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

    public int getItemImage() {
        return image;
    }

    public String getItemImageUrl() {
        return imageUrl;
    }



    // setter methods

    public void setItemName(String name) {
        this.name = name;
    }

    public void setItemDesc(String desc) {
        this.desc = desc;
    }

    public void setItemPrice(String price) {
        this.price = price;
    }

    public void setItemImage(int image) {
        this.image = image;
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
