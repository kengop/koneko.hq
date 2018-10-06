package com.hq.koneko.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

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
                    EditText editText = findViewById(R.id.editText2);
                    editText.setText(text);
                }
            }
        }
    }
}
