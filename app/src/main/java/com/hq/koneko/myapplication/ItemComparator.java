package com.hq.koneko.myapplication;

import java.util.Comparator;

public class ItemComparator {
    class AddDateComparator implements Comparator<ArticleData> {
        @Override
        public int compare(ArticleData lhs, ArticleData rhs) {
            return rhs.getAddDate().compareTo(lhs.getAddDate());
        }
    }

    class IssueDateComparator implements Comparator<ArticleData> {
        @Override
        public int compare(ArticleData lhs, ArticleData rhs) {
            return rhs.getIssueDate().compareTo(lhs.getIssueDate());
        }
    }

    class RatingComparator implements Comparator<ArticleData> {
        @Override
        public int compare(ArticleData lhs, ArticleData rhs) {
            Integer num1 = new Integer(rhs.getRating());
            Integer num2 = new Integer(lhs.getRating());
            return num1.compareTo(num2);
        }
    }
}