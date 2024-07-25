package com.example.ap_demo07;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public class UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll() {
        return null;
    }

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds) {
        return null;
    }

    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
    User findByName(String name) {
        return null;
    }

    @Insert
    void insertAll(User... users) {

    }

    @Delete
    void delete(User user) {

    }

}
