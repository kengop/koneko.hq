package com.hq.koneko.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class ScrollingActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling2);


        /** Intentを受け取る */
        Intent intent = getIntent();
        /** Intentの中身を取得 */
        int id = intent.getIntExtra("INDEX", 0);
        System.out.println(id);

        /** 文字列をとってくる */
        System.out.println("aaaaaaaa");

        ArticleData d = Store.getInstance().Data.get(id);
        RatingBar ratingBar = findViewById(R.id.ratingBar2);
        ratingBar.setRating(d.getRating());

        TextView abstView = findViewById(R.id.abst);
        abstView.setText(d.getAbstract());

        TextView memoView = findViewById(R.id.editText);
        memoView.setText(d.getComment());

        TextView citationView = findViewById(R.id.citation);
        citationView.setText("引用数: " + d.getCitationCount());


        TextView titleView = findViewById(R.id.detail_title);
        titleView.setText(d.getTitle());
    }
}
