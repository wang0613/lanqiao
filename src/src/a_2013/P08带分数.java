package src.a_2013;

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
public class P08带分数 {

    static int ans;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] arr = {1, 2, 3};
        f(arr, 0);

        System.out.println(ans);

    }

    //确认某一个排列的第k位
    private static void f(int[] arr, int k) {
        //全部确认，到达边界
        if (k == arr.length) {
            //添加 +  /看是够能否满足N
            check(arr);
            return;
            //放+ 号和  /

//            print(arr);
        }
        //选定第k为，
        for (int i = k; i < arr.length; i++) {
            //交换第i位和k位
            int t = arr[k];
            arr[k] = arr[i];
            arr[i] = t;

            // 移交下一位确认k+1为
            f(arr, k + 1);

            //调换回来，(回溯)
            t = arr[k];
            arr[k] = arr[i];
            arr[i] = t;
        }


    }


    //枚举 + 号和 /号的位置
    private static void check(int[] arr) {
        //在什么地方 放+号  在什么地方放/号
        //+ 前的字符数，最多是 7
        for (int i = 1; i <= 7; i++) {
            //如果此时 +号前的数字 已经超过了n 就没有比较验算了
            int num1 = toInt(arr, 0, i); // +号之前的整数
            if (num1 >= N) {
                continue;
            }

            // / 的位置是 9-i-1      i是+前面的数字  1是最后一位除数
            for (int j = 1; j <= arr.length-1-i; j++) {
                // 除法 / 前面的
                int num2 = toInt(arr, i, j);


                //最后一位 从两个数的后面开始    长度为总长度-i-j
                int num3 = toInt(arr, i + j, 9 - i - j);

                //必须整除 并满足算式
                if (num2 % num3 == 0 && num1 + num2 / num3 == N) {
                    ans++;

                }
            }
        }
    }

    // 将数组中的元素，凑成一个整数
    //pos:为开始位置，     length为个数
    private static int toInt(int[] arr, int pos, int length) {
        int t = 1;
        int ans = 0; //最终结果

        //倒着取，去最后一位的话是 10
        for (int i = pos+length-1; i >= pos; i--) {
            ans += arr[i] * t;


            t *= 10; //每次后面加个0
        }
        return ans;

    }
}
