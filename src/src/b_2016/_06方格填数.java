package src.b_2016;

/*
方格填数
如下的10个格子
    【】【】【】
【】【】【】【】
【】【】【】
(如果显示有问题，也可以参看[图7-1. jpg] )
填入0~9的数字。要求:连续的两个数字不能相邻。
(左右、上下、对角都算相邻)
一共有多少种可能的填数方案?
请填写表示方案数目的整数。
注意:你提交的应该是个整数，不要填写 任何多余的内容或说明性文字。
 */
import static java.lang.Math.*;
public class _06方格填数 {
    static int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int ans;

    public static void main(String[] args) {


        f(arr, 0);

        System.out.println(ans);

    }

    static void f(int[] arr, int k) {
        if (k == arr.length) {
            if (check()) {
                ans++;
            }

        }
        for (int i = k; i < arr.length; i++) {
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            f(arr, k + 1);

            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }

    }

    static boolean check() {

        if (abs(arr[0]-arr[1]) == 1 ||
            abs(arr[0]-arr[3]) == 1 ||
            abs(arr[0]-arr[4]) == 1 ||
            abs(arr[0]-arr[5]) == 1 ||

            abs(arr[1]-arr[2]) == 1 ||
            abs(arr[1]-arr[4]) == 1 ||
            abs(arr[1]-arr[5]) == 1 ||
            abs(arr[1]-arr[6]) == 1 ||

            abs(arr[2]-arr[5]) == 1 ||
            abs(arr[2]-arr[6]) == 1 ||

            abs(arr[3]-arr[4]) == 1 ||
            abs(arr[3]-arr[7]) == 1 ||
            abs(arr[3]-arr[8]) == 1 ||

            abs(arr[4]-arr[7]) == 1 ||
            abs(arr[4]-arr[8]) == 1 ||
            abs(arr[4]-arr[9]) == 1 ||
            abs(arr[4]-arr[5]) == 1 ||

            abs(arr[5]-arr[6]) == 1 ||
            abs(arr[5]-arr[8]) == 1 ||
            abs(arr[5]-arr[9]) == 1 ||

            abs(arr[6]-arr[9]) == 1 ||

            abs(arr[7]-arr[8]) == 1 ||

            abs(arr[8]-arr[9]) == 1
        ){
            return false;
        }
        return true;
    }
}
