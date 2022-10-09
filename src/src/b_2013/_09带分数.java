package src.b_2013;

import java.util.Scanner;

/*
带分数
 100 可以表示为带分数的形式：100 = 3 + 69258 / 714
 还可以表示为：100 = 82 + 3546 / 197
 注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
 类似这样的带分数，100 有 11 种表示法。
 题目要求：从标准输入读入一个正整数N (N<1000*1000)程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
 注意：不要求输出每个表示，只统计有多少表示法！
 例如：
 用户输入：100
 程序输出：11
 再例如：
 用户输入：105
  程序输出：6

N=n1+n2%n3;其中不难发现n1<=N;n2%n3==0; n2 > n3
剪枝成三个条件，减少运行时间，
然后将1~9这九个数字进行全排列，(全排列模板)
全排列也可以用dfs深度搜索。
 */
public class _09带分数 {
    static int ans;
    static int n;

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        n = new Scanner(System.in).nextInt();
        f(arr, 0);

        System.out.println(ans);
    }

    static void f(int[] arr, int k) {
        if (k == arr.length) {
            check(arr);
            return;
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

    //枚举 + /的位置
    private static void check(int[] arr) {
        //枚举+ 号的位置
        for (int i = 1; i <= 7; i++) {
            int num1 = toInt(arr, 0, i);

            if (num1 > n) continue;

            //留一个 /的位置
            for (int j = 1; j <= arr.length - i - 1; j++) {
                int num2 = toInt(arr, i, j);

                int num3 = toInt(arr, i + j, arr.length - i - j);

                if (num2 % num3 == 0 && num1+num2/num3 == n){
                    ans++;
                }

            }

        }

    }

    static int toInt(int[] arr, int begin, int end) {
        int t = 1;
        int ans = 0;
        for (int i = begin + end - 1; i >= begin; i--) {
            ans += t * arr[i];

            t *= 10;


        }
        return ans;
    }
}
