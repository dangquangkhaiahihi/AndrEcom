package com.allandroidprojects.ecomsample.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.allandroidprojects.ecomsample.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao getProductDAO();
}