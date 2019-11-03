package com.hbcu.utils;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.junit.jupiter.api.Test;

public class DateUtils {

    public static long getEndOfNextMonth() {
        DateTime now = new DateTime();
        DateTime afterMonth = now.plusMonths(1);
        return afterMonth.dayOfMonth().withMaximumValue().getMillis();
    }

    public static long getCurrentDate() {
        return Instant.now().getMillis();
    }

    public static int daysInMonthToEndOfContract(long finaDate) {
        DateTime endOfContract = new DateTime(finaDate);
        DateTime.Property property = endOfContract.dayOfMonth();
        return property.get();
    }

    public static int getCountOfDaysInMonth(long date) {
        DateTime dateTime = new DateTime(date);
        DateTime maxDate = dateTime.dayOfMonth().withMaximumValue();
        return maxDate.dayOfMonth().get();
    }

    @Test
    public void testMethod() {
//        DateTime endOfContract = new DateTime(1582048564000L);
        DateTime dateTime = new DateTime(1584554164000L);
        DateTime dateTime1 = dateTime.dayOfMonth().withMaximumValue();
        int i = dateTime1.dayOfMonth().get();
        System.out.println(i);
    }
}
