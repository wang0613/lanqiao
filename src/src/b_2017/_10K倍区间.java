package src.b_2017;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
问题描述
　　给定一个长度为N的数列，A1, A2, ... AN，如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <= j)之和是K的倍数，
我们就称这个区间[i, j]是K倍区间。

　　你能求出数列中总共有多少个K倍区间吗？
输入格式
　　第一行包含两个整数N和K。(1 <= N, K <= 100000)
　　以下N行每行包含一个整数Ai。(1 <= Ai <= 100000)
输出格式
　　输出一个整数，代表K倍区间的数目。
样例输入
5 2
1
2
3
4
5
样例输出
6
 */


public class _10K倍区间 {

    static int n, k;
    static int[] a;
    static int[] s; //前缀和
    static Map<Integer, Long> cnt = new HashMap<>();//同余个数统计

    public static void main(String[] args) {

        //使用取余数  组合数学
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n + 1];
        s = new int[n + 1];

        s[0] = 0;
        cnt.put(0, 1l);
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] = (s[i] - 1 + a[i]) % k;
            if (cnt.get(s[i]) == null) {
                cnt.put(s[i], 1l);
            } else {
                cnt.put(s[i], cnt.get(s[i]) + 1);
            }

        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += cnt.get(i) * (cnt.get(i - 1)) / 2;

        }
        System.out.println(ans);


    }

    //2；使用前缀和(特别大的数 超时)
    public static void f2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt(); //k的倍数
        int[] a = new int[N + 1];

        int[] s = new int[N + 1]; //前缀和数组

        //存入数组
        s[0] = 0;
        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i - 1] + a[i]; //存入前缀和数组
        }
        long ans = 0;
        //枚举i j
        for (int i = 1; i <= N; i++) {

            for (int j = i; j <= N; j++) {
                //i j之间的区间和   = s[j]-s[i-1]
                if ((s[j] - s[i - 1]) % K == 0) {
                    ans++;
                }
            }
        }
        System.out.println(ans);


    }

    //1：使用暴力法枚举(严重超时)
    public static void f() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt(); //k的倍数
        int[] a = new int[N];

        //存入数组
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();

        }

        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            //N-i 就是剩下的长度
            for (int j = 0; j < N - i; j++) {

                sum += a[i + j];
                //可以加到最后 一位

                if (sum % K == 0) {
                    ans++;
                }

            }

        }
        System.out.println(ans);
    }
}
