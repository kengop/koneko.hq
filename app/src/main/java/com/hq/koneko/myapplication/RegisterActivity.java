package com.hq.koneko.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    ArticleData currentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /** Intentを受け取る */
        Intent intent = getIntent();
        /** Intentの種類を取得 */
        String action = intent.getAction();
        /** "共有" だったら処理をつづける */
        if(action.equals(Intent.ACTION_SEND)) {
            /** Intentの中身を取得 */
            Bundle extras = intent.getExtras();
            /** 何も取得できないなら何もしない */
            if(extras != null) {
                CharSequence text = extras.getCharSequence(Intent.EXTRA_TEXT);
                /** 文字列をとってくる */
                if(text != null) {
                    /** ブラウザからだとURLがはいってます */
//                    EditText editText = findViewById(R.id.editText2);
                    ArticleData d = Store.getInstance().Data.get(0);
                    ArticleData ad = new ArticleData(
                            "" + (Store.getInstance().Data.size() + 1),
                            d.Title,
                            d.Author,
                            d.Journal,
                            d.IssueDate,
                            d.Rating,
                            d.Abstract,
                            d.CitationCount,
                            "",
                            new Date(),
                            text.toString()
                            );
                    this.currentData = ad;
//                    editText.setText(text);
                }
            }
        }
    }

    /** アプリを閉じるときはこのメソッドを呼んであげる */
    public void closeApplication(View view) {
        EditText editText = findViewById(R.id.editText2);
        this.currentData.Comment = editText.getText().toString();
        Store.getInstance().Data.add(this.currentData);



        moveTaskToBack(true);
    }
}
