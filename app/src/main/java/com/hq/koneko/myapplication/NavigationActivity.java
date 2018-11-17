package com.hq.koneko.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        AdapterView.OnItemClickListener {

    private ArrayAdapter<ArticleData> _adapterX;
    ArrayList<ArticleData> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /** 一覧 */
        ListView myListView = (ListView) findViewById(R.id.myListView);

        // データを準備

        for (ArticleData article : Store.getInstance().Data) {
            items.add(article);
        }

        this._adapterX = new ArticleListAdapter(
                this,
                R.layout.list_item,
                items
        );

        // ListViewに表示
        myListView.setAdapter(this._adapterX);

        // クリックリスナーをセット
        myListView.setOnItemClickListener(this);

        ItemComparator itemComparator = new ItemComparator();
        Collections.sort(items, itemComparator.new AddDateComparator());
        this._adapterX.notifyDataSetChanged();

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onSpinnerSelected(spinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_googlescholar) {
            // Handle the camera action

            // Handle the googlescholar action
            Uri uri = Uri.parse("https://scholar.google.co.jp");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_trashbox) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(
                this.getApplicationContext(), ScrollingActivity2.class); // ここで詳細の画面を指定する

        // 詳細に渡すデータをここで決める
        // hint: positionはタップした行の番号
//        ArticleData data = Store.getInstance().Data.get(position);
        // インテントにセット

        System.out.println(position);
        intent.putExtra("INDEX", position);

        // SubActivityへ遷移
        startActivity(intent);
    }

    // myListViewの昇順/降順を切り替える
    public void onSortListView(View view) {
        // itemsの要素の順序を逆する
        Collections.reverse(this.items);
        // myListViewにバインドした_adapterXに対して、
        // 表示する要素(items)に変更(並び順や要素の数など)があったことを通知する
        this._adapterX.notifyDataSetChanged();
    }

    public void onSpinnerSelected(Spinner spinner) {
        int position = spinner.getSelectedItemPosition();
        ItemComparator itemComparator = new ItemComparator();
        if (position == 0) {
            Collections.sort(items, itemComparator.new AddDateComparator());
        } else if (position == 1) {
            Collections.sort(items, itemComparator.new IssueDateComparator());
        } else if (position == 2) {
            Collections.sort(items, itemComparator.new RatingComparator());
        } else {
        }
        this._adapterX.notifyDataSetChanged();
    }

    public void onSearch(View v) {
        EditText keywordBox = findViewById(R.id.keywordBox);
        String keyword = keywordBox.getText().toString();
        items.clear();
        for (ArticleData itemData : Store.getInstance().Data) {
            String title = itemData.getTitle();
            int result = title.indexOf(keyword);
            if (result != -1) {
                items.add(itemData);
            }
        }
        ItemComparator itemComparator = new ItemComparator();
        Collections.sort(items, itemComparator.new AddDateComparator());
        this._adapterX.notifyDataSetChanged();
    }

    private PopupWindow popupWin;
    public void onAdvancedSearch(View button){
        if (this.popupWin == null) {
            View popLayout = getLayoutInflater().inflate(R.layout.advanced_search, null);
            this.popupWin = new PopupWindow();
            this.popupWin.setContentView(popLayout);
            this.popupWin.setOutsideTouchable(true);
            this.popupWin.setFocusable(true);
            this.popupWin.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
            this.popupWin.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
            this.popupWin.setBackgroundDrawable(getDrawable(R.drawable.flame_style));
        }
            this.popupWin.showAsDropDown(button, 0, 0);
    }

    public void onCustomizedSearch(View button){
        View popupView = this.popupWin.getContentView();
        RadioGroup radioGroup = (RadioGroup)popupView.findViewById(R.id.radioGroup);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        CheckBox inTitle = (CheckBox)popupView.findViewById(R.id.inTitle);
        CheckBox inAbst = (CheckBox)popupView.findViewById(R.id.inAbst);
        CheckBox inMemo = (CheckBox)popupView.findViewById(R.id.inMemo);
        EditText keywordBox = findViewById(R.id.keywordBox);
        String keyword = keywordBox.getText().toString();
        items.clear();
        if(checkedId == R.id.andSearch){
            //AND検索のとき
            for(ArticleData itemData : Store.getInstance().Data){
                String title = itemData.getTitle();
                int inTitleResult = title.indexOf(keyword);
                String abst = itemData.getAbstract();
                int inAbstResult = abst.indexOf(keyword);
                String memo = itemData.getComment();
                int inMemoResult = memo.indexOf(keyword);
                if(inTitle.isChecked() && inTitleResult == -1){
                    continue;
                }else if(inAbst.isChecked() && inAbstResult == -1){
                    continue;
                }else if(inMemo.isChecked() && inMemoResult == -1) {
                    continue;
                }else if(!inTitle.isChecked() && !inAbst.isChecked() && !inMemo.isChecked()){
                    break;
                }else {
                    items.add(itemData);
                }
            }
        }else if(checkedId == R.id.orSearch){
            //OR検索のとき
            for(ArticleData itemData : Store.getInstance().Data){
                String title = itemData.getTitle();
                int inTitleResult = title.indexOf(keyword);
                String abst = itemData.getAbstract();
                int inAbstResult = abst.indexOf(keyword);
                String memo = itemData.getComment();
                int inMemoResult = memo.indexOf(keyword);
                if(inTitle.isChecked() && inTitleResult != -1){
                    items.add(itemData);
                    continue;
                }else if(inAbst.isChecked() && inAbstResult != -1){
                    items.add(itemData);
                    continue;
                }else if(inMemo.isChecked() && inMemoResult != -1){
                    items.add(itemData);
                }
            }
        }
        ItemComparator itemComparator = new ItemComparator();
        Collections.sort(items, itemComparator.new AddDateComparator());
        this._adapterX.notifyDataSetChanged();
        popupWin.dismiss();
    }


}
