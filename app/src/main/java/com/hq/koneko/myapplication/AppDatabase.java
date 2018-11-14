package com.hq.koneko.myapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

/**
 * Created by k-inaba on 2018/11/11.
 */

@Database(entities = {Article.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDao articleDao();
}
