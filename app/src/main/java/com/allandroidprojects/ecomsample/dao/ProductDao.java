package com.allandroidprojects.ecomsample.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.allandroidprojects.ecomsample.model.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    public void insert(Product... products);

    @Query("SELECT * FROM product WHERE name LIKE '%' || :keyword || '%' OR desc LIKE '%' || :keyword || '%' OR phone LIKE '%' || :keyword || '%'")
    public List<Product> searchByKeyword(String keyword);

    @Query("SELECT * FROM product")
    public List<Product> getAllProducts();

    @Query("SELECT * FROM product WHERE category = :category")
    public List<Product> getItemByCategory(String category);

    @Query("SELECT * FROM product WHERE id = :id")
    public Product getItemById(Long id);
}