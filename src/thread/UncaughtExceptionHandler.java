package thread;

/**
 * 未捕获异常处理器
 * Created by darcy on 2018/1/29.
 */
public class UncaughtExceptionHandler {

//  1.如果父线程组存在, 则调用它的uncaughtException方法
//  2.如果父线程组不存在, 但指定了默认处理器 , 则调用默认的处理器
//  3.如果默认处理器没有设置, 则写错误日志.但如果 exception是ThreadDeath实例的话, 忽略
    public static void main(String[] args) {

        System.out.println(Thread.getDefaultUncaughtExceptionHandler());
        Thread t = new Thread(() -> {
            int a = 1 / 0;
        });

    }

}
