package com.allandroidprojects.ecomsample.utility;

import java.util.ArrayList;

public class ImageUrlUtils {
    static ArrayList<String> wishlistImageUri = new ArrayList<>();
    static ArrayList<String> cartListImageUri = new ArrayList<>();

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
