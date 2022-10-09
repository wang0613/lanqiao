package src.a_2016;

import java.util.Arrays;

/*
寒假作业： 现在的寒假作业也不是那么好玩
看看这个寒假作业
每个方块代表1~13中的某一个数字，但不能重复。
比如:

    6 + 7=13
    9 - 8= 1
    3 * 4=12
    10 / 2= 5
以及:
    7 + 6=13
    9 - 8=1
    3 * 4=12
    10/2 = 5
就算两种解法。(加法， 乘法交换律后算不同的方案)
你一共找到了多少种方案?
请填写表示方案数目的整数。
注意:你提交的应该是一个 整数，不要填写任何多余的内容或说明性文字。

64
 */
//全排列+检查
public class _06寒假作业_优化 {
    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    static int ans;

    public static void main(String[] args) {


        f(0);
        System.out.println(ans);
    }

    static void f(int k) {
        if (k == a.length) {
            ans++;
        }

        for (int i = k; i < a.length; i++) {

            int t = a[i];
            a[i] = a[k];
            a[k] = t;

            //可以提前做剪枝，优化速速
            if (k == 2 && (a[0] + a[1] != a[2]) ||
                    k == 5 && (a[3] - a[4] != a[5]) ||
                    k == 8 && (a[6] * a[7] != a[8]) ||
                    k == 11 && ((a[9] % a[10] != 0) || (a[9] / a[10] != a[11]))) {

                //注意交换回来
                t = a[i];
                a[i] = a[k];
                a[k] = t;
                continue;
            }


            f(k + 1);

            t = a[i];
            a[i] = a[k];
            a[k] = t;
        }
    }
}
