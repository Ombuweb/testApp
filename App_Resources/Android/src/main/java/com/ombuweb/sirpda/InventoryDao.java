package com.ombuweb.sirpda;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface InventoryDao {

    @Insert
    ListenableFuture<Long> insert(Inventory inventory);

    @Query("DELETE FROM inventarios WHERE inventory_id = :id")
    ListenableFuture<Void> deleteInventory(Integer id);

    @Query("DELETE FROM inventarios")
    ListenableFuture<Void> deleteAll();

    @Query("SELECT * from inventarios")
    LiveData<List<Inventory>> getAllInventories();

    /*@Transaction
    @Query("SELECT * FROM inventarios")
    public List<InventoryWithProducts> getInventoriesWithProducts();*/
}
