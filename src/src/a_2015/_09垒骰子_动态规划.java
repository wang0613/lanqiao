package src.a_2015;

import java.math.BigInteger;
import java.util.Scanner;

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
public class _09垒骰子_动态规划 {
    static long[][] dp = new long[2][7]; //dp[i][j]表示有i层，限定朝上的数字为j的稳定方案数
    static int n, m;
    static int[] op = new int[7]; //筛子的六个面
    //二维矩阵定义冲突面，  1  2   2  1
    static boolean[][] conflict = new boolean[7][7];
    static int MOD = BigInteger.valueOf(10).pow(9).add(BigInteger.valueOf(7)).intValue();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        //初始化筛子的六个面
        //1的对面是4, 2的对面是5，3的对面是6
        op[1] = 4;
        op[4] = 1;
        op[2] = 5;
        op[5] = 2;
        op[3] = 6;
        op[6] = 3;
        //初始化冲突面
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            //反面冲突
            conflict[x][y] = true;
            conflict[y][x] = true;

        }
        //输入完成
        for (int j = 1; j <= 6; j++) {
            dp[0][j] = 1;


        }
        int cur = 0;
//        迭代层数
        for (int level = 2; level <= n; level++) {
            cur = 1 - cur;
//            尝试将6个面放在当前一层朝上的方向
            for (int j = 1; j <= 6; j++) {
                dp[cur][j] = 0;
//                将与op[j]不冲突的上一层格子里面的数量加起来
                for (int i = 1; i <= 6; i++) {
                    if (conflict[op[j]][i]){
                        continue;//冲突面朝上是不可取的

                    }
                    dp[cur][j]=(dp[cur][j]+dp[1-cur][i])%MOD;

                }

            }

        }
        long sum = 0;
        for (int k = 1; k <= 6; k++) {
            sum = (sum+dp[cur][k])%MOD;

        }
        //快速幂求4的n次方
        long ans = 1;
        long temp = 4;
        long p = n;
        while (p != 0){
            if ((p&1) == 1){
                ans = (ans*temp)%MOD;
                p>>=1;
            }
        }
        System.out.println((sum*ans)%MOD);
    }

}
