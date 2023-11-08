package com.allandroidprojects.ecomsample.startup;

import android.app.Application;

import androidx.room.Room;

import com.allandroidprojects.ecomsample.cache.ImagePipelineConfigFactory;
import com.allandroidprojects.ecomsample.dao.AppDatabase;
import com.allandroidprojects.ecomsample.dao.ProductDao;
import com.allandroidprojects.ecomsample.dao.UserDao;
import com.allandroidprojects.ecomsample.model.Product;
import com.allandroidprojects.ecomsample.model.User;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class PetApplication extends Application {
    private AppDatabase mDb;

    @Override
    public void onCreate() {
        super.onCreate();

        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
        ProductDao productDao = mDb.getProductDAO();

        productDao.insert(new Product(
                1,
                "Labrador Retriever",
                "Friendly and outgoing nature. Intelligent and versatile dogs.",
                "$800",
                "https://images.pexels.com/photos/1739095/pexels-photo-1739095.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "dog"
        ));
        productDao.insert(new Product(2,
                "German Shepherd",
                "Loyalty, courage, and versatility, often employed as police and service dogs. Intelligent and trainable.",
                "$800",
                "https://images.pexels.com/photos/2071555/pexels-photo-2071555.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "dog"
        ));
        productDao.insert(new Product(3,
                "Golden Retriever",
                "Friendly and gentle temperament. Intelligence and are often used as therapy dogs.",
                "$500",
                "https://images.pexels.com/photos/686094/pexels-photo-686094.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "dog"
        ));
        productDao.insert(new Product(4,
                "Bulldog",
                "Loose, saggy skin and distinctive pushed-in nose. Docile, willful, and great companions.   ",
                "$1500",
                "https://images.pexels.com/photos/3693208/pexels-photo-3693208.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "dog"
        ));
        productDao.insert(new Product(5,
                "Beagle",
                "Keen sense of smell and are often used in detection work. Friendly, curious, and have a strong hunting instinct.",
                "$400",
                "https://images.pexels.com/photos/11425353/pexels-photo-11425353.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "dog"
        ));
        productDao.insert(new Product(6,
                "Poodle",
                "Poodles are highly intelligent. Known for their hypoallergenic coats,associated with a sophisticated appearance.",
                "$500",
                "https://images.pexels.com/photos/1458911/pexels-photo-1458911.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "dog"
        ));

        productDao.insert(new Product(7,
                "Persian Cat",
                "Long, luxurious fur and distinctive flat face. Having a calm and gentle temperament.",
                "$500",
                "https://images.pexels.com/photos/7445055/pexels-photo-7445055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "cat"
        ));
        productDao.insert(new Product(8,
                "Siamese Cat",
                "Sleek, slender bodies, short coat, and striking blue almond-shaped eyes. Vocal, social, and often form strong bonds with their owners.",
                "$400",
                "https://images.pexels.com/photos/357141/pexels-photo-357141.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "cat"
        ));
        productDao.insert(new Product(9,
                "Maine Coon", "Tufted ears, bushy tails, and tufted paws. Friendly, sociable, and often referred to as \"gentle giants.\"",
                "$800",
                "https://images.pexels.com/photos/17006168/pexels-photo-17006168/free-photo-of-close-up-of-maine-coon.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "cat"
        ));
        productDao.insert(new Product(10,
                "Bengal Cat",
                "Distinctive spotted or marbled coat, resembling that of a wild leopard. Energetic, playful, and may exhibit very active behavior.",
                "$1.000 ",
                "https://images.pexels.com/photos/16761425/pexels-photo-16761425/free-photo-of-bengal-cat-on-white-background.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "0559261020",
                "cat"
        ));

        UserDao userDao = mDb.getUserDAO();
        userDao.insert(new User("admin@gmail.com","ADMIN","admin", "123456", "1,2,3"));

        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
    }

}
