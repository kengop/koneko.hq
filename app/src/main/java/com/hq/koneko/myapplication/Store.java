package com.hq.koneko.myapplication;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k-inaba on 2018/10/06.
 */

public class Store {
    private static Store _ins = new Store();

    private Store() {
    }

    public ArrayList<Article> Data = new ArrayList<>();

    private Context context;
    public void SetContext(Context context) {
        this.context = context;
    }

    public static Store getInstance() {
        return _ins;
    }

    public void add(Article dd) {
        this.Data.add(dd);
    }

    public void LoadArticles() {
        this.loadFromDatabase();
    }

    private void loadFromDatabase() {
        new AsyncTask<Integer, Integer, List<Article>>() {

            private Context appContext;
            private ArrayList<Article> result;
            public AsyncTask<Integer, Integer, List<Article>> SetContext(Context context, ArrayList<Article> result) {
                this.appContext = context;
                this.result = result;
                return this;
            }
            @Override
            protected void onPostExecute(List<Article> result) {
                this.result.addAll(result);
            }
            @Override
            protected List<Article> doInBackground(Integer... integers) {
                boolean isDebugMode = false;
                // todo: to singleton
                AppDatabase db;
                ArrayList<Article> at = new ArrayList<>();

                if (isDebugMode) {
                    db = Room.inMemoryDatabaseBuilder(this.appContext,
                            AppDatabase.class).build();

                    List<Article> loadedList;
                    TsvReader reader = new TsvReader();
                    loadedList = reader.readTestData(this.appContext);

                    for (Article a: loadedList) {
                        db.articleDao().insertAll(a);
                    }
                    at.addAll(loadedList);
                } else {
                    db = Room.databaseBuilder(this.appContext,
                            AppDatabase.class, "database-name").build();
                    at.addAll(db.articleDao().getAll());
                }

                // for Debug
                for (Article a: at) {
                    System.out.println(a.getTitle());
                }

                return at;
            }
        }
        .SetContext(this.context, this.Data)
        .execute();

    }

}
