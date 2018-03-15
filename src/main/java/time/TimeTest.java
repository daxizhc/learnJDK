package time;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.LocalDate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeTest {
    public TimeTest() {
    }

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.parse("2017-01-01");
        LocalDate date2 = LocalDate.parse("2018-01-02");
        System.out.println(date1.compareTo(date2));
        String str1 = "2017-01-01";
        String str2 = "2018-01-02";
        System.out.println(str1.compareTo(str2));

//       日期转月份
        Date date3 = new LocalDate(2018,3,15).toDate();
        date3 = DateUtils.truncate(date3,Calendar.MONTH);
//        date3 = DateUtils.truncate(date3,Calendar.YEAR);
        System.out.println(date3);

    }
}