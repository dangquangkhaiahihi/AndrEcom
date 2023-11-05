package com.allandroidprojects.ecomsample.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.allandroidprojects.ecomsample.model.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    public void insert(Product... products);
    @Update
    public void update(Product... products);
    @Delete
    public void delete(Product product  );

    @Query("SELECT * FROM product")
    public List<Product> getItems();

    @Query("SELECT * FROM product WHERE id = :id")
    public Product getItemById(Long id);

}