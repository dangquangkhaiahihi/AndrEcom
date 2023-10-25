package com.allandroidprojects.ecomsample.model;

import java.util.ArrayList;
import java.util.List;

import com.allandroidprojects.ecomsample.R;

public class SearchProduct {

    public final List<Product> productList;

    public SearchProduct()
    {

        productList = new ArrayList<>();

        // Dogs
        productList.add(new Product("Bass Guitar", "Classical guitar  type of chordophone, traditionally constructed from wood and strung", "152.8",
            "https://static.pexels.com/photos/1543/landscape-nature-man-person-medium.jpg", "0559261020"));

        productList.add(new Product("Study Glasses", "Peter Jones Anti-Reflective Round Unisex Sunglasses - (NA90|48|White Color Lens)", "320.8",
                "https://static.pexels.com/photos/211048/pexels-photo-211048-medium.jpeg", "0559261020"));

        productList.add(new Product("Wall Clock","Density Collection Digital Clocks Battery Powered Led 7 Colors Changing Night Light Star Sky Digital Led", "80.8",
                "https://static.pexels.com/photos/1778/numbers-time-watch-white-medium.jpg", "0559261020"));


        productList.add(new Product("Sewing Machine", "Brother Sewing Machine, XM2701, Lightweight Sewing Machine with 27 Stitches", "431.8",
                "https://static.pexels.com/photos/111147/pexels-photo-111147-medium.jpeg", "0559261020"));

        productList.add(new Product("White Lamp","Modernluci Wall Sconce LED Wall Light Modern Plug in Bedroom Lamp Dark Grey", "91.8",
               "https://static.pexels.com/photos/2713/wall-home-deer-medium.jpg", "0559261020"));

        productList.add(new Product("Camera", "Kodak PIXPRO Astro Zoom AZ401-BK 16MP Digital Camera with 40X Optical Zoom and 3 LCD (Black)", "720.8",
                "https://static.pexels.com/photos/168575/pexels-photo-168575-medium.jpeg", "0559261020"));


        // Cats
        productList.add(new Product("Persian Cat", "Long, luxurious fur and distinctive flat face. Having a calm and gentle temperament.", "$500",
               "https://images.pexels.com/photos/7445055/pexels-photo-7445055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "0559261020"));

        productList.add(new Product("Siamese Cat", "Sleek, slender bodies, short coat, and striking blue almond-shaped eyes. Vocal, social, and often form strong bonds with their owners.", "$400",
                 "https://images.pexels.com/photos/357141/pexels-photo-357141.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "0559261020"));

        productList.add(new Product("Maine Coon", "Tufted ears, bushy tails, and tufted paws. Friendly, sociable, and often referred to as \"gentle giants.\"", "$800",
                 "https://images.pexels.com/photos/17006168/pexels-photo-17006168/free-photo-of-close-up-of-maine-coon.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "0559261020"));

        productList.add(new Product("Bengal Cat", "Distinctive spotted or marbled coat, resembling that of a wild leopard. Energetic, playful, and may exhibit very active behavior.", "$1.000",
                "https://images.pexels.com/photos/16761425/pexels-photo-16761425/free-photo-of-bengal-cat-on-white-background.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "0559261020"));
    }

    public List<Product> getProductList(){
        return productList;
    }
}
