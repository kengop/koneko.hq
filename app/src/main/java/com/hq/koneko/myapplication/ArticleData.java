package com.hq.koneko.myapplication;

import java.util.Date;

/**
 * Created by k-inaba on 2018/10/06.
 */

public class ArticleData {
    public String ID;
    public String Title;
    public String Author;
    public String Journal;
    public Date  IssueDate;
    public Integer Rating;
    public String Abstract;
    public Integer CitationCount;
    public String Comment;
    public Date AddDate;

    public ArticleData(
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
        this.ID = id;
        this.Title = title;
        this.Author = author;
        this.Journal = journal;
        this.IssueDate = issueDate;
        this.Rating = rating;
        this.Abstract = abst;
        this.CitationCount = citationCount;
        this.Comment = comment;
        this.AddDate = addDate;
    }
}
