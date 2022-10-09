package src.b_2014;

import java.util.Scanner;

/*
X国王有一个地宫宝库。是n x m个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
地宫的入口在左上角，出口在右下角。
小明被带到地宫的入口，国王要求他只能向右或向下行走。
走过某个格子时，
如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它(当然，也可以不拿)。

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
public class Main {
    static int n, m, k;
    static int[][] data;
    static long ans;
    static final int MOD = 1000000007;  //取模

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, -1, 0);
        System.out.println(ans%MOD);

    }

    private static void dfs(int x, int y, int max, int ctn) {

        //如果坐标点，超出了格子，或者说宝贝的数量已经超过了需要的K件数
        //防御(出界问题)
        if (x == n || y == m || ctn > k) {
            return;
        }

        //国王要求他只能向右或向下行走。
        int cur = data[x][y]; //当前坐标的宝贝价值

        //出口(已经走到最后一个格子)
        if (x == n - 1 && y == m - 1) {

            //如果当前的宝贝数量，已经到达K件
            if (ctn == k) {
                ans++;
            }
            //如果在最后一个格子，但是手中的物品正好差一个，并且当前点的价格还要比max大
            //可以直接拿着这个宝贝，就走了，这也算一种情况
            if (ctn == k - 1 && cur > max) {
                ans++;
            }
        }


        if (cur > max) {
            //如果当前点的价值，大于max，可以向下走，还可以向右走

            //如果拿个宝贝，两种路线
            // 最大值结是cur(当前个字的宝贝价值)
            dfs(x + 1, y, cur, ctn + 1); //向下走
            dfs(x, y + 1, cur, ctn + 1);//向右走
        }

        //如果不拿宝贝
        dfs(x + 1, y, max, ctn); //向下走
        dfs(x, y + 1, max, ctn);//向右走

    }


}
