package src.digui.p02;

import java.util.Arrays;

/*
求n个元素的全排列
 */
public class Test2 {

    //abcde
    public static void main(String[] args) {

        char[] arr = {'A', 'B', 'C', 'D', 'E'};

        f(arr, 0);

    }

    public static void f(char[] arr, int k) {
        if (arr.length == k) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = k; i < arr.length; i++) {

            //使用临时变量进行交换
            char t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            f(arr, k + 1);

            //回溯
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

        }
    }
}
