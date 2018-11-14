package com.hq.koneko.myapplication;
import android.arch.persistence.room.*;

import java.util.List;

/**
 * Created by k-inaba on 2018/11/11.
 */

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM article")
    List<Article> getAll();

    @Insert
    void insertAll(Article... articles);

    @Delete
    void delete(Article article);

}
