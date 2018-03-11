package time;

import java.time.LocalDate;

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
    }
}