package com.hq.koneko.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by k-inaba on 2018/10/06.
 */
@Entity
public class Article {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    private String id;
    private String title;
    private String author;
    private String journal;



    private Date issueDate;
    private int rating;
    private String abst;
    private int citationCount;
    private String comment;
    private Date addDate;
    private String url;

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJournal() {
        return this.journal;
    }
    public void setJournal(String journal) {
        this.journal = journal;
    }

    public Date getIssueDate() {
        return this.issueDate;
    }
    public void setIssueDate(Date issuDate) {
        this.issueDate = issuDate;
    }

    public int getRating() {
        return this.rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAbst() {
        return this.abst;
    }
    public void setAbst(String abst) {
        this.abst = abst;
    }

    public int getCitationCount() {
        return this.citationCount;
    }
    public void setCitationCount(int citationCount) {
        this.citationCount = citationCount;
    }

    public String getComment() {
        return this.comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getAddDate() {
        return this.addDate;
    }
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


    public Article() {}

    @Ignore
    public Article(
            String id,
            String title,
            String author,
            String journal,
            Date issueDate,
            Integer rating,
            String abst,
            Integer citationCount,
            String comment,
            Date addDate
    ) {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setJournal(journal);
        this.setIssueDate(issueDate);
        this.setRating(rating);
        this.setAbst(abst);
        this.setCitationCount(citationCount);
        this.setComment(comment);
        this.setAddDate(addDate);
    }

    @Ignore
    public Article(
            String id,
            String title,
            String author,
            String journal,
            Date issueDate,
            Integer rating,
            String abst,
            Integer citationCount,
            String comment,
            Date addDate,
            String url
    ) {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setJournal(journal);
        this.setIssueDate(issueDate);
        this.setRating(rating);
        this.setAbst(abst);
        this.setCitationCount(citationCount);
        this.setComment(comment);
        this.setAddDate(addDate);
        this.setUrl(url);
    }
}
