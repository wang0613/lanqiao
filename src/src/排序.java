package src;

import java.util.Arrays;

public class 排序 {

    public static void main(String[] args) {
        int[] arr = {12, -23, 31, 77, 4, 32, 43, 43};

        sort(arr);


        System.out.println(Arrays.toString(arr));

    }

    //冒泡
    public static void sort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < i; j++) {
                if (args[j] > args[j + 1]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }

            }
        }
    }

    //倒着的冒泡排序
    public static void sort2(int[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (args[j] > args[j + 1]) {
                    int temp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = temp;
                }

            }

        }
    }

    //二分查找
    public static int sor3(int[] arr, int target) {
        int begin = 0; //最小坐标
        int end = arr.length - 1; //最大坐标

        int mid = 0;

        while (begin <= end) {
            mid = (begin + end) / 2;  //去中间坐标

            //比关键字大则关键字在左区域
            if (arr[mid] > target) {
                end = mid + 1;
                //比关键字小则关键字在右区域
            } else if (arr[mid] < target) {
                begin = mid - 1;
            } else {
                //相等返回值
                return mid;
            }

        }
        return -1;
    }


}
