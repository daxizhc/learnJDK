package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by darcy on 2018/1/30.
 */
public class MyThreadLocal {

    private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("initialValue for "+Thread.currentThread().getName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(simpleDateFormat);
            return simpleDateFormat;
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5 ; i++) {
            System.out.println(new MyThreadLocal());

//            new Thread(() -> {
//                //string为不同的，SimpleDateFormat为相同的，mythreadlocal为不同的，什么原因？ p661
//                System.out.println(dateFormat.get().format(new Date()));
//            }).start();
        }


    }

}
