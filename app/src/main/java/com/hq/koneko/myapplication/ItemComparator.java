package com.hq.koneko.myapplication;

import java.util.Comparator;

public class ItemComparator {
    class AddDateComparator implements Comparator<Article> {
        @Override
        public int compare(Article lhs, Article rhs) {
            return rhs.getAddDate().compareTo(lhs.getAddDate());
        }
    }

    class IssueDateComparator implements Comparator<Article> {
        @Override
        public int compare(Article lhs, Article rhs) {
            return rhs.getIssueDate().compareTo(lhs.getIssueDate());
        }
    }

    class RatingComparator implements Comparator<Article> {
        @Override
        public int compare(Article lhs, Article rhs) {
            Integer num1 = new Integer(rhs.getRating());
            Integer num2 = new Integer(lhs.getRating());
            return num1.compareTo(num2);
        }
    }
}