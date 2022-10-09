package src.a_2013;


import java.util.Arrays;
import java.util.Scanner;

/*
很久以前，T王国空前繁荣。为了更好地管理国家，王国修建了大量的快速路，用于连接首都和王国内的各大城市。
为节省经费，T国的大臣们经过思考，制定了一套优秀的修建方案，使得任何一个大城市都能从首都直接或者通过其他大城市间接到达。
同时，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。

J是T国重要大臣，他巡查于各大城市之间，体察民情。所以，从一个城市马不停蹄地到另一个城市成了J最常做的事情。
他有一个钱袋，用于存放往来城市间的路费。

聪明的J发现，如果不在某个城市停下来修整，在连续行进过程中，他所花的路费与他已走过的距离有关，
在走第x千米到第x+1千米这一千米中（x是整数），他花费的路费是x+10这么多。也就是说走1千米花费11，走2千米要花费23。

J大臣想知道：他从某一个城市出发，中间不休息，到达另一个城市，所有可能花费的路费中最多是多少呢？

输入格式:
输入的第一行包含一个整数n，表示包括首都在内的T王国的城市数
城市从1开始依次编号，1号城市为首都。

接下来n-1行，描述T国的高速路（T国的高速路一定是n-1条）

每行三个整数Pi, Qi, Di，表示城市Pi和城市Qi之间有一条高速路，长度为Di千米。

输出格式
输出一个整数，表示大臣J最多花费的路费是多少。

样例输入1
5
1 2 2
1 3 1
2 4 5
2 5 4
样例输出1
135
输出格式
大臣J从城市4到城市5要花费135的路费。
 */
public class P10大臣的旅费_2 {


    public static int max;
    public static int n;
    public static int[][] a;//存储树每一条边的长度
    public static int sum = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        a = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++)//二维数组赋初始值
        {
            Arrays.fill(a[i], -1);
            a[i][i] = 0;
        }
        for (int i = 1; i < n; i++)//将树每一条边的值存入
        {
            int p = input.nextInt();
            int q = input.nextInt();
            a[p][q] = a[q][p] = input.nextInt(); //两点的值
        }
        input.close();
        //开始遍历寻找最长路径
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++)
            {
                dfs(i, i, j);
            }
        }
        int price = (10 + max + 11) * max / 2;
        System.out.println(price);
    }

    //路径开始点，邻点，结束点
    public static void dfs(int start, int next, int end) {
        if (next == end)//当邻点等于结束点时 结束遍历
        {
            sum += a[start][end];
            if (sum > max)
                max = sum;
            return;
        } else {
            sum += a[start][next];
            for (int i = 1; i <= n; i++) {
                if (i != start && i != next && a[next][i] != -1) {
                    dfs(next, i, end);
                    //回溯
                    sum -= a[next][i];
                }
            }
        }
    }

}
