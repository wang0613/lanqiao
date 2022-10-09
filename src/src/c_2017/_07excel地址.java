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
public class _07excel地址 {

    static int[] ans = new int[100];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        solve1(n);

    }

    static void solve1(long n) {
        for (int i = 1; i <= n; ++i) {
            ans[0]++;
            int tmp = 0;

            if (ans[0] == 27) {
                tmp = 1;//表示进位
                ans[0] = 1; //回到1

                //进位往后作用
                int t = 1;
                while (tmp > 0 && t < 100) {
                    ans[t] += tmp;
                    if (ans[t] == 27) {
                        ans[t] = 1;
                        tmp = 1;
                    } else {
                        tmp = 0;
                    }
                    t++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 100; ++k) {
            if (ans[k] == 0) {
                break;
            }
            //往前面插入
            sb.insert(0, (char) ('A' + (ans[k] - 1)));
        }
        System.out.println(sb);

    }





}
