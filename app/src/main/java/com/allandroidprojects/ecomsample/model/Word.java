package com.allandroidprojects.ecomsample.model;


import java.util.ArrayList;

public class Word {

    private String name;
    private String desc;
    private String price;
    private String phone;

    static ArrayList<Word> wishlist = new ArrayList<>();
    static ArrayList<Word> MyCard = new ArrayList<>();

    public Word(String name, String desc, String price, String phone)
    {

        this.name = name;
        this.desc = desc;
        this.price = price;
        this.phone = phone;    }

    public Word()
    {
        name = null;
        desc = null;
        price = null;
    }

    public void SetWishList(Word word)
    {
        this.wishlist.add(0, word);

    }

    public ArrayList<Word> getWishlist(){return wishlist;}

    public void removeWishList(int position)
    {
        wishlist.remove(position);
    }



    public ArrayList<Word> getMyCard(){return MyCard;}

    public void removeMyCard(int position)
    {
        MyCard.remove(position);
    }


    public void SetMyCard(Word word)
    {
        MyCard.add(0, word);

    }






    public String getWordName() {
        return name;
    }

    public String getWordDesc() {
        return desc;
    }

    public String getWordPrice() {
        return price;
    }

}
