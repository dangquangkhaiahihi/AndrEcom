package com.allandroidprojects.ecomsample.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.allandroidprojects.ecomsample.model.User;

import java.util.List;


@Dao
public interface UserDao {
    @Insert
    public void insert(User... users);

    @Update
    public void update(User... users);

    @Query("SELECT * FROM user WHERE username = :username")
    public User searchByUsername(String username);
}
