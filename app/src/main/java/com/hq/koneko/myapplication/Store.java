package com.hq.koneko.myapplication;

import android.content.Context;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k-inaba on 2018/10/06.
 */

public class Store {
    private static Store _ins = new Store();

    private Store() {}

    public ArrayList<ArticleData> Data = new ArrayList<>();

    private Context context;
    public void SetContext(Context context) {
        this.context = context;
    }

    public static Store getInstance() {
        return _ins;
    }

    public void add(ArticleData dd) {
        this.Data.add(dd);
    }

    public void LoadArticles() {
        List<ArticleData> loadedList;
        try {
            loadedList = this.createMockData();

            int index = 1;
            for (ArticleData d: loadedList) {
                ArticleData x = d;
            x.setId("" + index);

                this.Data.add(x);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private List<ArticleData> createMockData() throws ParseException {
        TsvReader reader = new TsvReader();
        return reader.readTestData(this.context);
    }

}
