package src.c_2019;

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

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        //求第一个数和 每一数字 的最大公差
        int min = arr[1];
        int max = arr[N];
        int index = 0;
        int [] c = new int[N]; //存放当前数字和min之间的公差
        for (int i = 2; i <= N; i++) {
            c[index++] = arr[i] - min;

        }
        System.out.println(max+" "+min);
        int d = 0;
        //求最大公差
        for (int i = 0; i < index; i++) {
            d  = gcd(c[i],d);
        }

        if (d == 0){
            System.out.println(N);
        }else {
            System.out.println((max-min)/d+1);
        }

    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
