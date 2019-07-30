import TimeChange.TimeChange;

import java.util.Scanner;

public class TestForData {
    public static void main(String[] args) {
        //用for循环和递归的方式完成1*2*3*...*n的结果
        TimeChange tc = new TimeChange();
        Scanner sc = new Scanner(System.in);

        //for循环
        System.out.println("for循环打印结果");
        int n = sc.nextInt();
        int num =1;
        System.out.println("计算" + n + "的阶乘");
        for(int i = 1;i < n+1;i ++){
            num = num * i;
        }
        System.out.println(n + "的阶乘结果：" + num);

        tc.show();

        //递归方式
        System.out.println("递归方式打印n的阶乘");
        int nn = sc.nextInt();
        System.out.println("计算" + nn + "的阶乘");
        int result = result(nn);
        System.out.println(nn + "的阶乘结果：" + result);
    }

    //定义一个计算n的阶乘的递归算法
    private static int result(Integer num){
        if(num == 1){
            return 1;
        } else {
            return num * result(num-1);
        }
    }

}
