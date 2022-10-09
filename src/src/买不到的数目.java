package src;

import java.util.Scanner;

/*
小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。

小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。

你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。

本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。

输入格式
两个正整数，表示每种包装中糖的颗数(都不多于1000)

输出格式
一个正整数，表示最大不能买到的糖数

样例输入
4 7
样例输出
17

样例输入
3 5
样例输出
7
 */
//和包子凑数是同一种题目
//不能买到的最大的是a*b-a-b
//本题可以直接使用 公式进行取解
public class 买不到的数目 {
    static boolean[] f = new boolean[100000];
    static int g;
    static int a;
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        d = new int[100000];

        f[0] = true;
        for (int i = 1; i <= 2; i++) {


            a = sc.nextInt();
            d[i] = a;

            //初始化最大公约数
            if (i == 1) {
                g = d[i];
            } else {
                g = gcd(d[i], g);
            }

            for (int j = 0; j < 100000 - d[i]; j++) {
                //如果 f[j]
                if (f[j]) {
                    f[j + d[i]] = true;
                }


            }

        }

        //最大不可以凑出的数 从大到小
        for (int j = d[1] * d[2]; j > 1; j--) {

            //j是不可以凑出来的个数
            if (!f[j]) {
                System.out.println(j);
                break;
            }

        }

    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
