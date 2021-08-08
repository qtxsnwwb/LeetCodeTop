package demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.HOUR_OF_DAY, -2);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(calendar.getTime());
        System.out.println(date);
        calendar.add(Calendar.HOUR_OF_DAY, -2);
        date = df.format(calendar.getTime());
        System.out.println(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)-1, 0, 0, 0);
        date = df.format(calendar.getTime());
        System.out.println(date);
    }
}
