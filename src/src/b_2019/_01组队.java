package src.b_2019;

import java.util.Scanner;

/*
作为篮球队教练，你需要从以下名单中选出 1 号位至 5 号位各一名球员， 组成球队的首发阵容。

每位球员担任 1 号位至 5 号位时的评分如下表所示。
请你计算首发阵容 1 号位至 5 号位的评分之和最大可能是多少？

如果你把以上文字复制到文本文件中，请务必检查复制的内容是否与文 档中的一致。在试题目录下有一个文件 team.txt，内容与上面表格中的相同， 请注意第一列是编号
97 90 0 0 0
92 85 96 0 0
0 0 0 0 93
0 0 0 80 86
89 83 97 0 0
82 86 0 0 0
0 0 0 87 90
0 97 96 0 0
0 0 89 0 0
95 99 0 0 0
0 0 96 97 0
0 0 0 93 98
94 91 0 0 0
0 83 87 0 0
0 0 98 97 98
0 0 0 93 86
98 83 99 98 81
93 87 92 96 98
0 0 0 89 92
0 99 96 95 81

 */

//490
public class _01组队 {
    static int max;
    static int[][] pp = new int[21][6];

    static int[] vis = new int[21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {

            for (int j = 0; j < 5; j++) {
                pp[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);

        System.out.println(max);

    }

    static void dfs(int p, int sum) {
        if (p > 5) {
            if (sum > max) {
                max = sum;
            }
        } else {
            for (int i = 0; i < 20; i++) {
                if (vis[i] == 0) {
                    vis[i] = 1;
                    dfs(p + 1, sum + pp[i][p]);
                    vis[i] = 0;
                }

            }
        }
    }

}
