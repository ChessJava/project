import TimeChange.TimeChange;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCode2 {
    public static void main(String[] args) {
        //LocalDate ld = LocalDate.now();
        TimeChange tc = new TimeChange();
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(
                2,4,1000,TimeUnit.MILLISECONDS,new LinkedBlockingQueue());
        if(tpe.isShutdown()){
            System.out.println("Start线程池已关闭！！！");
        } else {
            System.out.println("Start线程池已开启！！！");
        }
        int[] index = {0};
        tpe.execute(() -> {
            List<Integer> list = new ArrayList();
            try {
                for(int i=0;i<10;i++) {
                    index[0] = i;
                    System.out.println("子线程1: "+index[0]);
                    list.add(index[0]);
                    tc.show();
                    //Thread.sleep(1000);
                    /*if(i == 9){
                        tpe.shutdown();
                    }*/
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("子线程1__list数据:");
                for(Integer number : list){
                    System.out.print(number + " ");
                }
            }
        });
        tpe.execute(()->{
            List<Integer> list = new ArrayList();
            try {
                for(int i = 0;i < 10;i++) {
                    index[0] = i;
                    System.out.println("子线程2: "+index[0]);
                    list.add(index[0]);
                    tc.show();
                    //Thread.sleep(1000);
                    /*if(i == 9){
                        tpe.shutdown();
                    }*/
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("子线程2__list数据:");
                for(Integer number : list){
                    System.out.print(number + " ");
                }
            }
        });
        tpe.shutdownNow();
        if(tpe.isShutdown()){
            System.out.println("End线程池已关闭！！！");
        } else {
            System.out.println("End线程池已开启！！！");
        }
    }
}
