package com.hq.koneko.myapplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Store.getInstance().SetContext(getApplicationContext());
		Store.getInstance().LoadArticles();

		// データベースへのアクセス
//		Task t = new Task(getApplicationContext());
//		t.execute();

		// タイトルを非表示にします。
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//
		setContentView(R.layout.activity_main);
		Handler hdl = new Handler();
		// 500ms遅延させてsplashHandlerを実行します。
		hdl.postDelayed(new splashHandler(), 1000);
	}


	class splashHandler implements Runnable {
		public void run() {
			// スプラッシュ完了後に実行するActivityを指定します。
			Intent intent = new Intent(getApplication(), NavigationActivity.class);
			startActivity(intent);
			// SplashActivityを終了させます。
			MainActivity.this.finish();
		}
	}
}
