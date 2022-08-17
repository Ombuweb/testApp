package com.ombuweb.sirpda;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;

@Database(entities = {Product.class,Inventory.class}, version = 2, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class InventoryRoomDatabase  extends RoomDatabase {

    private static InventoryRoomDatabase INSTANCE;
    public abstract InventoryDao inventoryDao();
    public abstract ProductDao productDao();
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    //new PopulateDbAsync(INSTANCE).execute();
                    InventoryDao inventoryDao = INSTANCE.inventoryDao();
                    ProductDao productDao = INSTANCE.productDao();

                }
            };

    public static InventoryRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (InventoryRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            InventoryRoomDatabase.class,"inventory:database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                    .build();
                }
            }
        }
        return INSTANCE;
    }


}
