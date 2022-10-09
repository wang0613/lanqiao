package src.b_2017;
/*
小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。每种蒸笼都有非常多笼，可以认为是无限笼。

　　每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。比如一共有3种蒸笼，分别能放3、4和5个包子。当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个的再加2笼4个的）。

　　当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。而顾客想买7个包子时，大叔就凑不出来了。
　　小明想知道一共有多少种数目是包子大叔凑不出来的。
输入格式
　　第一行包含一个整数N。(1 <= N <= 100)
　　以下N行每行包含一个整数Ai。(1 <= Ai <= 100)
输出格式
　　一个整数代表答案。如果凑不出的数目有无限多个，输出INF。
样例输入
2
4
5
样例输出
6
样例输入
2
4
6
样例输出
INF
样例说明
　　对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。
　　对于样例2，所有奇数都凑不出来，所以有无限多个。
 */

import java.util.Scanner;

public class _08包子凑数 {


    static int n, g;
    static int[] a = new int[101];//输入的数据

    //100*100-200凑不出的最大数
    //m*n-m-n
    static boolean[] f = new boolean[10000];//凑不出的最大数组

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        f[0] = true;//f0一定是可以凑出来的

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();

            //初始化最大公约数
            if (i == 1)
                g = a[i];
            else //求当前的最大公约数
                g = gcd(a[i], g);
            //完全背包的递推
            for (int j = 0; j < 10000 - a[i]; j++) {
                if (f[j]) {
                    //如果当前的这个数是可以凑出来的
                    f[j + a[i]] = true;
                }

            }

        }
        //如果最大公约数不是1 说明是无限的
        if (g != 1) {
            System.out.println("INF");
            return;
        }
        //统计个数
        int ans = 0;
        for (int j = 0; j < 10000; j++) {

            //j是不可以凑出来的个数
            if (!f[j]) {
                ans++;
                System.out.println(j);
            }

        }
        System.out.println("-------------");
        //统计凑不出来的个数
        System.out.println(ans);

    }
}
