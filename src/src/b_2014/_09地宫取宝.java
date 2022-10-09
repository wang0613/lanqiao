package src.b_2014;

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

import java.util.Scanner;


//深搜dfs问题
public class _09地宫取宝 {
    static int n, m, k; //n行数据，每行有m个整数，k表示宝贝数量
    static int[][] data;
    static final int MOD = 1000000007;  //取模
    //    static long ans;

    //记忆性递归数组
    //开辟长度为最大值+1
    static long[][][][] cache = new long[51][51][14][14];

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
        //初始化，数组中的所有元素为为 -1
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                for (int l = 0; l < 14; l++) {
                    for (int o = 0; o < 14; o++) {
                        cache[i][j][l][o] = -1;

                    }

                }

            }

        }


        //max如果为-1，数组的下标是没有-1的，报错，这里采用全体max+1
        //数组的长度需要+1
        long rs = dfs2(0, 0, -1, 0);
        System.out.println(rs);


        //给定默认最大值 -1(第一个点的价值可能是0，不能是0)
        //该数字可能很大，输出它对1000000007 取模的结果。
//        System.out.println(ans % MOD);

    }


    /**
     * 深搜dfs
     * @param x   坐标
     * @param y   坐标
     * @param max 如果格子中宝贝比小明手中的宝贝值钱，小明就可以拿起它(当然，也可以不拿)
     * @param ctn 记录宝贝的数量
     */
   /* private static void dfs(int x, int y, int max, int ctn) {

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

            //1: 如果当前的宝贝数量，已经到达K件
            //2: 如果在最后一个格子，但是手中的物品正好差一个，并且当前点的价格还要比max大
            //可以直接拿着这个宝贝，就走了，这也算一种情况
            if (ctn == k || (ctn == k - 1 && cur > max)) {
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

    }*/

    //使用记忆性递归 记性改造(解决超时问题)
    //1：记忆性递归只需要在开头和结尾做文章
    //先查缓存，缓存中有，直接拿来用
    private static long dfs2(int x, int y, int max, int ctn) {
        //改造超时问题(使用记忆性递归)

        //先查询缓存
        if (cache[x][y][max+1][ctn] != -1) {
            return cache[x][y][max+1][ctn];
        }
        long ans = 0;

        //如果坐标点，超出了格子，或者说宝贝的数量已经超过了需要的K件数
        //防御(出界问题)
        if (x == n || y == m || ctn > k) {
            return 0;
        }

        //国王要求他只能向右或向下行走。
        int cur = data[x][y]; //当前坐标的宝贝价值

        //出口(已经走到最后一个格子)
        if (x == n - 1 && y == m - 1) {
            //1: 如果当前的宝贝数量，已经到达K件
            //2: 如果在最后一个格子，但是手中的物品正好差一个，并且当前点的价格还要比max大
            //可以直接拿着这个宝贝，就走了，这也算一种情况
            if (ctn == k || (ctn == k - 1 && cur > max)) {
                ans++;
            }

            return ans;
        }


        if (cur > max) {
            //如果当前点的价值，大于max，可以向下走，还可以向右走
            //如果拿个宝贝，两种路线
            // 最大值结是cur(当前个字的宝贝价值)
            ans += dfs2(x + 1, y, cur, ctn + 1); //向下走
            ans += dfs2(x, y + 1, cur, ctn + 1);//向右走
        }
        //如果不拿宝贝
        ans += dfs2(x + 1, y, max, ctn); //向下走
        ans += dfs2(x, y + 1, max, ctn);//向右走

        //做缓存，在结果return之前
        cache[x][y][max+1][ctn] = ans % MOD;
        return ans;

    }
}
