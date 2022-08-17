package com.ombuweb.sirpda;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

public class InventoryRepository {

    private InventoryDao mInventoryDao;
    private LiveData<List<Inventory>> mAllInventories;

    InventoryRepository(Application application){
        InventoryRoomDatabase db = InventoryRoomDatabase.getDatabase(application);
        mInventoryDao = db.inventoryDao();
        mAllInventories =mInventoryDao.getAllInventories();
    }

    LiveData<List<Inventory>> getAllInventories(){
        return  mAllInventories;
    }

    ListenableFuture<Long> insert(Inventory inventory){
        //new  insertAsyncTask(mInventoryDao).execute(inventory);
        return mInventoryDao.insert(inventory);
    }
void deleteInventory(Integer id){
        mInventoryDao.deleteInventory(id);
}
   /* private static class insertAsyncTask extends AsyncTask<Inventory, Void, Integer> {

        private InventoryDao mAsyncTaskDao;

        insertAsyncTask(InventoryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Integer doInBackground(final Inventory... params) {
            //Integer i = ((int) mAsyncTaskDao.insert(params[0]));
            return null;
        }

@Override
        protected void onPostExecute(Integer integer) {
            Log.i("ROOMY", (integer).toString());
        }
    }*/
}

