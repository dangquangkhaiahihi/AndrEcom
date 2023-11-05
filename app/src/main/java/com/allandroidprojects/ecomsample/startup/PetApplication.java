package com.allandroidprojects.ecomsample.startup;

import android.app.Application;

import androidx.room.Room;

import com.allandroidprojects.ecomsample.cache.ImagePipelineConfigFactory;
import com.allandroidprojects.ecomsample.dao.AppDatabase;
import com.facebook.drawee.backends.pipeline.Fresco;

public class PetApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();

        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
    }

}
