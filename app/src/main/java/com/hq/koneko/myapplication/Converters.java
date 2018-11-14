package com.hq.koneko.myapplication;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by k-inaba on 2018/11/14.
 */

public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
