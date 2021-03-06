package com.hq.koneko.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

/**
 * Created by k-inaba on 2018/10/06.
 */

public class ArticleListAdapter extends ArrayAdapter<ArticleData> {

    private int mResource;
    private List<ArticleData> mItems;
    private LayoutInflater mInflater;

    public ArticleListAdapter(@NonNull Context context, int resource, List<ArticleData> items) {
        super(context, resource, items);

        mResource = resource;
        mItems = items;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView != null) {
            view = convertView;
        }
        else {
            view = mInflater.inflate(mResource, null);
        }

        // リストビューに表示する要素を取得
        ArticleData item = mItems.get(position);

        // タイトルを設定
        TextView title = (TextView)view.findViewById(R.id.detail_title);
        title.setText(item.getTitle());
        TextView author = (TextView)view.findViewById(R.id.author);
        author.setText(item.getAuthor());
        RatingBar star = (RatingBar)view.findViewById(R.id.ratingBar);
        star.setRating(item.getRating());
        TextView journal = (TextView)view.findViewById(R.id.journal);
        journal.setText(item.getJournal());

        TextView date = (TextView)view.findViewById(R.id.date);
        if(item.getIssueDate() == null) {
            date.setText("-");
        }else{
            Calendar datetime = Calendar.getInstance();
            datetime.setTime(item.getIssueDate());
            date.setText("" + datetime.get(Calendar.YEAR));
        }

        TextView add = (TextView)view.findViewById((R.id.addDate));
        if(item.getAddDate() == null){
            add.setText("-");
        }else{
            add.setText(item.getAddDate().toString());
        }

        return view;
    }
}
