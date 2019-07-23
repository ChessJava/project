
import TimeChange.TimeChange;

import java.time.LocalDate;
import java.util.concurrent.*;

public class TestCode {
    public static void main(String[] args) {
        //LocalDate ld = LocalDate.now();

        TimeChange tc = new TimeChange();
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(
                2,3,1000,TimeUnit.MILLISECONDS,new LinkedBlockingQueue());
        if(tpe.isShutdown()){
            System.out.println("Start线程池已关闭！！！");
        } else {
            System.out.println("Start线程池已开启！！！");
        }
        for(int i = 0; i < 10; i++){
            final int index = i;
            tpe.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        tc.show();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        if(tpe.isShutdown()){
            System.out.println("End线程池已关闭！！！");
        } else {
            System.out.println("End线程池已开启！！！");
        }
    }
}
