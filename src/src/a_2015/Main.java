package src.a_2015;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
垒骰子

赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。
经过长期观察，atm发现了稳定骰子的奥秘:有些数字的面贴着会互相排斥!

我们先来规范一下骰子:      1的对面是4, 2的对面是5，3的对面是6。

假设有m组互斥现象，每组中的那两个数字的面紧贴在一起， 骰子就不能稳定的垒起来。
atm想计算一下有多少种不同的可能的垒骰子方式???
两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。

由于方案数可能过多，请输出模10^9 + 7的结果。
不要小看了atm的骰子数量哦~
    「输入格式」
第一行两个整数n m
n表示骰子数目
接下来m行，每行两个整数a b，表示a和b数字不能紧贴在一起。
    「输出格式」
一行一个数，表示答案模10^9 + 7的结果。
[样例输入]
    2   1
    1   2
[样例输出]
    544

[数据范围」
对于30%的数据:n<=5
对于60% 的数据: n <= 100
对于100%的数据:0<n<=10^9，m<=36
[资源消耗]
内存<256M
cpu消耗<2000ms


 */
//使用递归？？定义好上一面的结果，排除冲突面，继续下一面，
//本题使用暴力递归只能得30分
public class Main {
    static int MOD = BigInteger.valueOf(10).pow(9).add(BigInteger.valueOf(7)).intValue();
    static int[] op = new int[7];
    static int n, m;
    static boolean[][] conflict = new boolean[7][7];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        op[1] = 4;
        op[2] = 5;
        op[3] = 6;
        op[4] = 1;
        op[5] = 2;
        op[6] = 3;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            conflict[a][b] = true;
            conflict[b][a] = true;
        }
        long ans = 0;
        for (int i = 1; i <= 6; i++) {

            ans += 4 * dfs(i, n - 1) % MOD;
        }
        System.out.println(ans);

    }

    private static long dfs(int up, int n) {
        if (n ==0){
            return 4;
        }

        long ans = 0;
        for (int upp = 1; upp <= 6; upp++) {
            int np = op[up];
            if (conflict[np][upp]){
                continue;
            }else {
                ans+=(dfs(upp,n-1)) % MOD;
            }

        }
        return ans;

    }


}
