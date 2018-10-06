package com.hq.koneko.myapplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by k-inaba on 2018/10/06.
 */

public class Store {
    private static Store _ins = new Store();
    private Store() {
        this.createTestData();
    }

    public ArrayList<ArticleData> Data;

    public static Store getInstance() {
        return _ins;
    }

    private void createTestData() {
        ArrayList<ArticleData> list = new ArrayList<ArticleData>();
        int max = 10;
        Date issueDate = new Date();
        Date d = new Date();
        Random r = new Random();
        for (int i = 0; i < max; i++) {
            ArticleData x = new ArticleData("" + i,
                    "title" + i,
                    "author",
                    "journal",
                    issueDate,
                    r.nextInt(5),
                    "abst",
                    i,
                    "comment",
                    d);
            list.add(x);
        }
        this.Data = list;
    }
}
