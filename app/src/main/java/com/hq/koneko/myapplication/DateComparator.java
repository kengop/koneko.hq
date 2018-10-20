package com.hq.koneko.myapplication;

import java.util.Comparator;

public class DateComparator implements Comparator<ArticleData>
{
    @Override
    public int compare(ArticleData lhs, ArticleData rhs)
    {
        return rhs.IssueDate.compareTo(lhs.IssueDate);
    }
}
