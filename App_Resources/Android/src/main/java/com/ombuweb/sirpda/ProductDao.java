package com.ombuweb.sirpda;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    ListenableFuture<Long[]> insertProducts(List<Product> products);

@Insert(onConflict = OnConflictStrategy.REPLACE)
    ListenableFuture<Long> insert(Product product);

    @Query("SELECT * FROM products")
    LiveData<List<Product>> getAllProducts();

    @Query("SELECT * FROM products WHERE inventory_id=:inventoryId")
    LiveData<List<Product>> findProductsForInventory(final int inventoryId);
}
