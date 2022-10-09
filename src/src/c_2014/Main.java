package src.c_2014;


/*
X国王有一个地宫宝库。是nxm个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
地宫的入口在左上角，出口在右下角。
小明被带到地宫的入口，国王要求他只能向右或向下行走。
走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它(当然，也可以不拿)。
当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。
请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。

输入一行3个整数，用空格分开: n m k (1<=n,m<=50, 1<=k<=12)
接下来有n行数据，每行有m个整数Ci (0<=Ci<=12)代表这个格子 上的宝物的价值
要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对1000000007 取模的结果。
例如，输入:
2 2 2
1 2
2 1
程序应该输出:
2
再例如，输入:
2 3 2
1 2 3
2 1 5
程序应该输出:
14
 */

import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int[][] g;
    static final int MOD = 1000000007;
    static long[][][][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        g = new int[n][m];
        cache = new long[51][51][14][14];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();

            }
        }
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                for (int l = 0; l < 14; l++) {
                    for (int o = 0; o < 14; o++) {
                        cache[i][j][l][o] = -1;

                    }

                }

            }

        }


        long rs = dfs(0, 0, -1, 0);
        System.out.println(rs);

    }

    //使用记忆性递归进行改造
    private static long dfs(int x, int y, int max, int ctn) {
        if (cache[x][y][max + 1][ctn] != -1) {
            return cache[x][y][max + 1][ctn];
        }
        long ans= 0;
        if (x == n || y == m || ctn > k) {
            return 0;
        }
        //获取当前点的
        int cur = g[x][y];
        if (x == n - 1 && y == m - 1) {
            if (ctn == k || (ctn == k - 1 && cur > max)) {
                ans++;
            }
            return ans;
        }


        if (cur > max) {
            //拿着当前点，向下走，或者向右走
            ans += dfs(x + 1, y, cur, ctn + 1);
            ans += dfs(x, y + 1, cur, ctn + 1);

        }
        //不拿宝贝
        ans += dfs(x + 1, y, max, ctn);
        ans += dfs(x, y + 1, max, ctn);

        cache[x][y][max + 1][ctn] = ans % MOD;

        return ans;

    }


}
