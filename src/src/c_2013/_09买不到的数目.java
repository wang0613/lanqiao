package src.c_2013;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
public class _09买不到的数目 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();


        Set<Integer> set = new HashSet<>();
        int max = a * b;

        for (int x = 0; a * x < max; x++) {
            for (int y = 0; a * x + b * y < max; y++) {
                //用不小于0和x与y系数能组合的数 加入set
                set.add(a * x + b * y);
            }
        }

        for (int i = max - 1; i >= 0; i--) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }

        }

    }
}
