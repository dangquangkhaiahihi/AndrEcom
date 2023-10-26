package com.allandroidprojects.ecomsample.fakedata;
import com.allandroidprojects.ecomsample.model.Product;

public class DogData extends ListProductData {
    public DogData()
    {
        super();
        products.add(
                new Product(
                        "Labrador Retriever",
                        "Friendly and outgoing nature. Intelligent and versatile dogs.",
                        "$800",
                        "https://images.pexels.com/photos/1739095/pexels-photo-1739095.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                        "0559261020"
        ));
        products.add(new Product(
                        "German Shepherd",
                        "Loyalty, courage, and versatility, often employed as police and service dogs. Intelligent and trainable.",
                        "$800",
                        "https://images.pexels.com/photos/2071555/pexels-photo-2071555.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                        "0559261020"
        ));
        products.add(new Product(
                        "Golden Retriever",
                        "Friendly and gentle temperament. Intelligence and are often used as therapy dogs.",
                        "$500",
                        "https://images.pexels.com/photos/686094/pexels-photo-686094.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                        "0559261020"
        ));
        products.add(new Product(
                        "Bulldog",
                        "Loose, saggy skin and distinctive pushed-in nose. Docile, willful, and great companions.   ",
                        "$1500",
                        "https://images.pexels.com/photos/3693208/pexels-photo-3693208.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                        "0559261020"
        ));
        products.add(new Product(
                        "Beagle",
                        "Keen sense of smell and are often used in detection work. Friendly, curious, and have a strong hunting instinct.",
                        "$400",
                        "https://images.pexels.com/photos/11425353/pexels-photo-11425353.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                        "0559261020"
        ));
        products.add(new Product(
                        "Poodle",
                        "Poodles are highly intelligent. Known for their hypoallergenic coats,associated with a sophisticated appearance.",
                        "$500",
                        "https://images.pexels.com/photos/1458911/pexels-photo-1458911.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                        "0559261020"
        ));
    }
}
