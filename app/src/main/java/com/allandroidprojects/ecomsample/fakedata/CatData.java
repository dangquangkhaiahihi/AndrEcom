package com.allandroidprojects.ecomsample.fakedata;

import com.allandroidprojects.ecomsample.model.Product;

public class CatData extends ListData {

    public CatData()
    {
        super();
        products.add(new Product(
                "Persian Cat",
                "Long, luxurious fur and distinctive flat face. Having a calm and gentle temperament.",
                "$500",
                "https://images.pexels.com/photos/7445055/pexels-photo-7445055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020"));
        products.add(new Product(
                "Siamese Cat",
                "Sleek, slender bodies, short coat, and striking blue almond-shaped eyes. Vocal, social, and often form strong bonds with their owners.",
                "$400",
                "https://images.pexels.com/photos/357141/pexels-photo-357141.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020"));
        products.add(new Product(
                "Maine Coon", "Tufted ears, bushy tails, and tufted paws. Friendly, sociable, and often referred to as \"gentle giants.\"",
                "$800",
                "https://images.pexels.com/photos/17006168/pexels-photo-17006168/free-photo-of-close-up-of-maine-coon.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020"));
        products.add(new Product("Bengal Cat",
                "Distinctive spotted or marbled coat, resembling that of a wild leopard. Energetic, playful, and may exhibit very active behavior.",
                "$1.000 ",
                "https://images.pexels.com/photos/16761425/pexels-photo-16761425/free-photo-of-bengal-cat-on-white-background.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020"));
    }
}
