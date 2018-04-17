package com.example.xubii.follproject.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {ground.class},version = 1)
public abstract class myDataBase extends RoomDatabase
{
    private static myDataBase INSTANCE;

    public abstract groundDao groundDao();

    public static myDataBase getAppDatabase(Context context) {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), myDataBase.class, "user-database").build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
