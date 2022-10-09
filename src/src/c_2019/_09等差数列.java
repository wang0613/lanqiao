package src.c_2019;

import java.util.Arrays;
import java.util.Scanner;

/*
等差数列

【问题描述】
数学老师给小明出了一道等差数列求和的题目。但是粗心的小明忘记了一 部分的数列，只记得其中 N 个整数。
现在给出这 N 个整数，小明想知道包含这 N 个整数的最短的等差数列有几项？

【输入格式】
输入的第一行包含一个整数 N。 第二行包含 N 个整数 A1,A2,··· ,AN。(注意 A1 ∼ AN 并不一定是按等差数 列中的顺序给出)

【输出格式】
输出一个整数表示答案。

【样例输入】
5 2 6 4 10 20

【样例输出】
10
 */
/*
1.它们都是同一个等差数列的值，因此它们中间俩俩的差，肯定是
nd(d是公差)，因为要求最短的等差数列，因此只需求所有的
俩俩差的最大公约数，求出最大公约数剩下的就好求了，
为

2.在俩俩相减前要先排序，使求出的nd是正数，为了方便，我们
把除第一位的每一位减去排序后的第一位，这样的结果也是nd
 */
public class _09等差数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int Max = arr[N]; //最大数
        int Min = arr[1]; //最小数
        int index = 0; //记录有多少公差
        //存放最大公差
        int[] cha = new int[N];

        for (int i = 2; i <= N; i++) {
            //找每个数与第一位的公差
            cha[index++] = arr[i] - Min;
        }
        int d = 0;
        //找最大公差
        for (int i = 0; i < index; i++) {
            d = gcd(cha[i], d);
        }

        //公差为0的时候原数组就是最小等差数列
        if (d == 0) {
            System.out.println(N);
        } else {
            System.out.println((Max - Min) / d + 1);
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
