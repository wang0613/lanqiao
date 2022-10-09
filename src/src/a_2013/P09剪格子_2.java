package src.a_2013;


/*
如下图所示，3 x 3 的格子中填写了一些整数。

+--*--+--+
|10* 1|52|
+--****--+
|20|30* 1|
*******--+
| 1| 2| 3|
+--+--+--+
我们沿着图中的星号线剪开，得到两个部分，每个部分的数字和都是60。

本题的要求就是请你编程判定：对给定的m x n 的格子中的整数，是否可以分割为两个部分，使得这两个区域的数字和相等。
如果存在多种解答，请输出包含左上角格子的那个区域包含的格子的最小数目。

如果无法分割，则输出 0。

输入格式
程序先读入两个整数 m n 用空格分割 (m,n<10)。

表示表格的宽度和高度。

接下来是n行，每行m个正整数，用空格分开。每个整数不大于10000。

输出格式
输出一个整数，表示在所有解中，包含左上角的分割区可能包含的最小的格子数目。
样例输入1
3 3
10 1 52
20 30 1
1 2 3
样例输出1
3

样例输入2
4 3
1 1 1 1
1 30 80 2
1 1 1 100
样例输出2
10
 */

//分析：先统计一下所以数的和sum，从左上角的格子出发，当走到某个格子的时候，
// 路径上的数和等于sum/2的时候，该剪法可以，返回步数
//最后返回所有合法步数的最小值
import java.util.Scanner;

import static java.lang.Math.*;
public class P09剪格子_2 {
    static int n, m;
    static int[][] a = new int[20][20]; //存放数据
    static int sum;//总和
    static int rs  = Integer.MAX_VALUE;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //四个方向
    static int[][] vis = new int[20][20];//标记已经走过的路线


    //c是步数 temp走过的总和
    static void dfs(int x, int y, int c, int temp) {
        //已经走过的和
        temp += a[x][y];
        c++;//步数+1
        //如果已经走得步数 是总数的一半，说明是一种可行的方案
        if (temp == sum / 2) {
            //rs是4000 如果无法分割 就是0
            rs = min(c,rs);
        }
        //标记为已访问
        vis[x][y] = 1;
        //4个方向
        for (int i = 0; i < 4; i++) {
            int xx = x + dir[i][0]; //传入的坐标+横轴坐标，形成新的坐标
            int yy = y + dir[i][1];

            //如果新的坐标 开没被访问过
            if (xx >= 1 && xx <= n && yy >= 1 && yy <= m && vis[xx][yy] == 0) {
                //进行dfs
                dfs(xx, yy, c, temp);

            }
        }
        vis[x][y] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();

                sum += a[i][j];
            }
        }
        //模拟结果的最大值
        dfs(1, 1, 0, 0);

        if (rs == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(rs);
        }
    }
}
