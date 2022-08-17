package com.ombuweb.sirpda;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository mProductRepo;
    @NonNull
    @Override
    public <T extends Application> T getApplication() {
        return super.getApplication();
    }

    public ProductViewModel (Application application) {
        super(application);
        mProductRepo = new ProductRepository(application);


    }

    public void  insertProducts(List<Product> products){
        ListenableFuture<Long[]> future = mProductRepo.insertProducts(products);
        Log.i("INSE", products.get(1).inventory_id+"");

        try {
            Log.i("RAAM", future.get().toString());


        } catch (ExecutionException e) {
            Log.e("ERR: IN PROS", e.getMessage());
        } catch (InterruptedException e) {
            Log.e("ERR", e.getMessage());

        }
        mProductRepo.insertProducts(products);
    }

    public void insert(Product product){


        ListenableFuture<Long> future = mProductRepo.insert(product);

        try {
            Log.i("RAAM", future.get().toString());


        } catch (ExecutionException e) {
            Log.e("ERR1", e.getMessage());
        } catch (InterruptedException e) {
            Log.e("ERR", e.getMessage());

        }
    }

}
