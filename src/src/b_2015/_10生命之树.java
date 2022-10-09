package src.b_2015;

/*
生命之树

在X森林里，上帝创建了生命之树。
他给每棵树的每个节点(叶子 也称为一个节点)上， 都标了一个整数，代表这个点的和谐值。
上帝要在这棵树内选出一个非空节点集S，使得对于S中的任意两个点a,b,都存在一个点列 {a, v1, v2，.... vk, b}
使得这个点列中的每个点都是S里面的元素，且序列中相邻两个点间有一条边相连。

在这个前提下，上帝要使得S中的点所对应的整数的和尽量大。
这个最大的和就是上帝给生命之树的评分。

经过atm的努力，他已经知道了上帝给每棵树上每个节点上的整数。但是由于atm 不擅长计算，他不知道怎样有效的求评分。
他需要你为他写一个程序来计算一棵 树的分数。

    [输入格式]
第一行一个整数 n，表示这棵树有 n个节点。
第二行 n个整数，依次表示每个节点的评分。
接下来 n-1行，每行2个整数 u, v,表示存在一条u到v的边。由于这是一棵树，所以是不存在环的。
    [输出格式]
出一行一个数， 表示上帝给这棵树的分数。
    [样例输入]
5
1 -2 -3 4 5
4 2
3 1
1 2
2 5
    [样例输出]
8

分析：
给定一颗无根树，求所有节点的权值之和最大。求出最大的数是多少
例如：样例中的8，选1，2，4，5这4个点

用vector容器把两点之间的关系连接起来。
dp[u][1]:表示选这个点
dp[u][0]:表示不选这个点
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class _10生命之树 {
    static int n;
    //每个点的权重
    static long[] w;
    //使用邻接表
    static List<Integer>[] g;
    static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        w  = new long[n + 1];
        g = new ArrayList[n + 1];

        //处理输入 需要以1位节点，从1开始
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();

        }
        //初始化集合
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int j = 0; j < n - 1; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            //添加邻居
            g[u].add(v);
            g[v].add(u);

        }
        //以根为节点
        dfs(1, 0);
        System.out.println(ans);


    }

    //无根树转有根树的dfs
    //以root为根，算出最大的权和，将其存储在w[root]中
    static void dfs(int root, int father) {

        //遍历所有的邻居
        List<Integer> linjus = g[root];
        for (int i = 0; i < linjus.size(); i++) {
            //其中的一个孩子
            int son = linjus.get(i);

            if (son == father)
                continue;
            dfs(son, root);

            if (w[son] > 0) {
                w[root] += w[son];
            }

        }
        if (w[root] > ans) {
            ans = w[root];
        }
    }
}
