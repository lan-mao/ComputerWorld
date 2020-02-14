package basic;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDate {
    public static void main(String[] args) {
        Date date = new Date(-Long.MAX_VALUE);
        System.out.println(date.toString());
        Calendar calendar = new GregorianCalendar(2020,1,29,18,21);
        calendar.get(Calendar.MONDAY);
        System.out.println(calendar);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
    }
}
