package src.c_2016;

/*

凑算式
    B     DEF
A+ ----+ ------ = 10
    C     GHI
(如果显示有问题，可以参见[图1. jpg] )
这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
比如:
6+8/3+952/714就是一种解法，
5+3/1+972/486是另一种解法。
这个算式一共有多少种解法?
注意:你提交应该是个整数，不要填写任何多余的内容或说明性文字。
*/
/*
B     DEF           B    X1         B*X2+X1*C
---+ ------ ===>  ---- + ----   ===> ------ ====>  (B*X2+X1*C) % C*X2 == 0 && a[0]+(B*X2+X1*C)/C*X2==10
C     GHI           C    X2          C*X2
 */
public class _06凑算式 {
    static int ans;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        f(arr, 0);
        System.out.println(ans);

    }

    static void f(int[] arr, int k) {
        if (k == arr.length) {
            if (check(arr)){
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

    private static boolean check(int[]arr) {
        int x = arr[3]*100+arr[4]*10+arr[5];
        int y = arr[6]*100+arr[7]*10+arr[8];

        if ((arr[1]*y+arr[2]*x)%(arr[2]*y)==0 && arr[0]+(arr[1]*y+arr[2]*x)/(arr[2]*y) == 10){
            return true;
        }
        return false;


    }
}
