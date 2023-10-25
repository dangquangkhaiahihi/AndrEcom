package com.allandroidprojects.ecomsample.utility;

import java.util.ArrayList;

public class ImageUrlUtils {
    static ArrayList<String> wishlistImageUri = new ArrayList<>();
    static ArrayList<String> cartListImageUri = new ArrayList<>();

    public static String[] getOffersUrls() {
        String[] urls = new String[]{
            "https://static.pexels.com/photos/1543/landscape-nature-man-person-medium.jpg",
            "https://static.pexels.com/photos/211048/pexels-photo-211048-medium.jpeg",
            "https://static.pexels.com/photos/1778/numbers-time-watch-white-medium.jpg",
            "https://static.pexels.com/photos/111147/pexels-photo-111147-medium.jpeg",
            "https://static.pexels.com/photos/2713/wall-home-deer-medium.jpg",
            "https://static.pexels.com/photos/168575/pexels-photo-168575-medium.jpeg"
        };
        return urls;
    }

    public static String[] getCatImgUrls() {
        String[] urls = new String[]{
            "https://images.pexels.com/photos/7445055/pexels-photo-7445055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/357141/pexels-photo-357141.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/17006168/pexels-photo-17006168/free-photo-of-close-up-of-maine-coon.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            "https://images.pexels.com/photos/16761425/pexels-photo-16761425/free-photo-of-bengal-cat-on-white-background.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        };
        return urls;
    }

    // Methods for Wishlist
    public void addWishlistImageUri(String wishlistImageUri) {
        this.wishlistImageUri.add(0,wishlistImageUri);
    }

    public void removeWishlistImageUri(int position) {
        this.wishlistImageUri.remove(position);
    }

    public ArrayList<String> getWishlistImageUri(){ return this.wishlistImageUri; }

    // Methods for Cart
    public void addCartListImageUri(String wishlistImageUri) {
        this.cartListImageUri.add(0,wishlistImageUri);
    }

    public void removeCartListImageUri(int position) {
        this.cartListImageUri.remove(position);
    }

    public ArrayList<String> getCartListImageUri(){ return this.cartListImageUri; }
}
