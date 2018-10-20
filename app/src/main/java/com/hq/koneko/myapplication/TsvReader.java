package com.hq.koneko.myapplication;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by k-inaba on 2018/10/20.
 */

public class TsvReader {
    private static final String TestDataFileName = "testdata.tsv";

    public ArrayList<ArticleData> readTestData(Context context) {
        AssetManager assetManager = context.getResources().getAssets();
        ArrayList<ArticleData> result = new ArrayList<>();

        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(TestDataFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStream == null) {
            return result;
        }

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);

            String line;
            SimpleDateFormat isoFmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
            while ((line = bufferReader.readLine()) != null) {

                //タブ区切りで１つづつ配列に入れる
                ArticleData data = new ArticleData();
                String[] rowData = line.split("\t");

                //TSVの左([0]番目)から順番にセット
                // "id","title","author","journal","issue date","rating","abstract","citationount","comment","add date"
                data.setId(rowData[0]);
                data.setTitle(rowData[1]);
                data.setAuthor(rowData[2]);
                data.setJournal(rowData[3]);
                data.setIssueDate(isoFmt.parse(rowData[4]));
                data.setRating(Integer.parseInt(rowData[5]));
                data.setAbstract(rowData[6]);
                data.setCitationCount(Integer.parseInt(rowData[7]));
                data.setComment(rowData[8]);
                data.setAddDate(isoFmt.parse(rowData[9]));

                result.add(data);
            }

            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
