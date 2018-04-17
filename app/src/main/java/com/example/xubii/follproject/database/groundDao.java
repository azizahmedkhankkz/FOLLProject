package com.example.xubii.follproject.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
@Dao
public interface groundDao
{

    @Query("SELECT * FROM ground")
    List<ground> getAll();


    @Query("SELECT COUNT(*) from ground")
    int countGrounds();

    @Insert
    void insertAll(ground... g);

    @Delete
    void delete(ground g);

}
