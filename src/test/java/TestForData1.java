import java.util.Scanner;

//折半查找，二分算法
public class TestForData1 {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 100};
        Scanner sc = new Scanner(System.in);
        int index = getIndex(arr, sc.nextInt());
        System.out.println("寻找到的下标：" + index);
    }

    public static int getIndex(int[] arr, int result) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int index;
        while (true) {
            index = (minIndex + maxIndex) / 2;
            if (arr[index] == result) {
                return index;
            } else if (arr[index] > result) {
                maxIndex = index - 1;
            } else {
                minIndex = index + 1;
            }
            if (minIndex > maxIndex) {
                System.out.println("此元素不存在于数组中");
                return -1;
            }

        }
    }
}
