package com.ombuweb.sirpda;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class ProductRepository {

    private ProductDao mProductDao;
    private LiveData<List<Product>> mAllProducts;

    ProductRepository(Application application){
        InventoryRoomDatabase db = InventoryRoomDatabase.getDatabase(application);
        mProductDao = db.productDao();
        mAllProducts =mProductDao.getAllProducts();
    }

    LiveData<List<Product>> getAllProducts(){
        return  mAllProducts;
    }
ListenableFuture<Long> insert(Product product){
    Log.i("IN Pr","INSERT");return mProductDao.insert(product);
}
    ListenableFuture<Long[]> insertProducts(List<Product> products){
        Log.i("IN Pr", products.get(1).getLote());
        //new  insertAsyncTask(mProductDao).execute(Product);
        ListenableFuture<Long[]> l = mProductDao.insertProducts(products);
        Log.i("iii", l.toString());
        return l;
    }
}
