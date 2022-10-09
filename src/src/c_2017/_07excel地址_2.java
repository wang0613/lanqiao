package src.c_2017;

import java.util.Scanner;

/*
标题:
Excel地址
Excel单元格的地址表示很有趣，它使用字母来表示列号。
比如，
    A表示第1列，
    B表示第2列，
    Z表示第26列，
    AA表示第27列，
    AB表示第28列，
    BA表示第53列，
    ······
当然Excel的最大列号是有限度的，所以转换起来不难。
如果我们想把这种表示法一般化， 可以把很大的数字转换为很长的字母序列呢?

本题目即是要求对输入的数字，输出其对应的Excel地址表示方式。
例如，
    输入:
    26
    则程序应该输出:
    Z

再例如：
    输入：
    2054
    则程序输出
    BZZ
 */
public class _07excel地址_2 {

    static long[] ans = new long[100];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        solve1(n);

    }

    //使用进制法
    //将处理后的数据放入数组
    static void solve1(long n) {

        int ctn = 0;
        while (n != 0) {
            if (n % 26 == 0) {

                ans[ctn++] = 26; //特殊处理，能够出尽的情况下，把26作为余数 27是A
                n = n / 26 - 1; //商减少1 作为被除数
            } else {
                ans[ctn++] = n % 26; //记录余数
                n = n / 26; //将商作为被除数，继续进行
            }

        }

        //倒着取
        for (int i = ctn - 1; i >= 0; i--) {

            //A 本身就是1 所以需要 -1
            System.out.print((char) ('A' + (ans[i] - 1)));

        }


    }


}
