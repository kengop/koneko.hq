package com.hq.koneko.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.RatingBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    private final Handler handler = new Handler();
    private ArticleData newArticle;
    private WebView webView;

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
            for (String key: intent.getExtras().keySet()) {
                System.out.println(key);
            }
            /** Intentの中身を取得 */
            Bundle extras = intent.getExtras();
            /** 何も取得できないなら何もしない */
            if(extras != null) {
                CharSequence text = extras.getCharSequence(Intent.EXTRA_TEXT);
                /** 文字列をとってくる */
                if(text != null) {
                    /** ブラウザからだとURLがはいってます */

                    // NOTE: 取得したURLをWebViewで開き、レンダリング後のソースをparse可能にする
                    this.webView = (WebView) findViewById(R.id.mywebview);
                    this.webView.getSettings().setJavaScriptEnabled(true);
                    this.webView.getSettings().setBuiltInZoomControls(true);
                    this.webView.setWebViewClient(new WebViewClient() {});
                    this.webView.addJavascriptInterface(this, "MyWebViewActivity");

                    this.webView.loadUrl(text.toString());
                }
            }
        }
    }

    @JavascriptInterface
    public void viewSource(final String src) {
        handler.post(new Runnable() {
            @Override
            public void run() {

                Document document = Jsoup.parse(src);

                // NOTE: Dependency on Google Scholar
                Elements es = document.select("#gs_qabs");
                Element head = es.first();
                String cidAttr = head.attr("data-cid");

                // 常に3記事をロードしている作り
                int gsListIndex;
                switch (cidAttr) {
                    case "gs_id100":
                        gsListIndex = 1;
                        break;
                    case "gs_id101":
                        gsListIndex = 2;
                        break;
                    case "gs_id102":
                        gsListIndex = 3;
                        break;
                    default:
                        // todo: 例外処理
                        System.out.println("想定外なので取得処理を中断する");
                        gsListIndex = 0;
                }

                System.out.println(gsListIndex);
                Elements elements = document.select(".gs_psd_p");
                Element e = elements.get(gsListIndex);

                // todo: このあたり例外処理
                // title
                Elements titleElement = e.select(".gs_qabs_title");
                String title = titleElement.first().text();

                // author
                Elements authorElement = e.select(".gs_qabs_au2");
                String author = authorElement.first().text();

                // journal and publish date
                Elements pubElement = e.select(".gs_qabs_pub");
                String pub = pubElement.first().text();

                Date publishDate = null;
                if (pub != null && pub != "") {

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    String[] sp = pub.split(",");
                    // pubの後ろに発行年が記載されている
                    String last = sp[sp.length - 1];
                    Integer publishDateInt = Integer.parseInt(last.trim());
                    if (publishDateInt > 0) {

                        try {
                            // TODO: 暫定的に1月1日をセット
                            publishDate = sdf.parse("" + publishDateInt + "/01/01");
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                }

                // abstract
                Elements abstractElement = e.select(".gsh_csp");
                String abstractText = abstractElement.first().text();

                // for debug
                String artStr = title + "\n"
                        + author + "\n"
                        + pub + "\n"
                        + abstractText;
                System.out.println(artStr);

                // create ArticleData
                RatingBar ratingBar = findViewById(R.id.ratingBar);
                EditText editText = findViewById(R.id.editText2);

                newArticle = new ArticleData("" + (Store.getInstance().Data.size() + 1),
                        title, author, pub, publishDate, (int)ratingBar.getRating(), abstractText,
                        0, editText.getText().toString(), new Date(), src);

                // save ArticleData
                Store.getInstance().Data.add(newArticle);

                // reset form status
                Intent intent = new Intent(
                        getApplicationContext(), NavigationActivity.class);
                startActivity(intent);

                // back to browser
                moveTaskToBack(true);
            }
        });
    }

    public void closeApplication(View view) {
        this.webView.loadUrl("javascript:window.MyWebViewActivity.viewSource(document.documentElement.outerHTML);");
    }
}
