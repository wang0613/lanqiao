package src.c_2014;

import java.util.Scanner;

/*
标题:兰顿蚂蚁
兰顿蚂蚁，是于1986年由克里斯.兰顿提出来的，属于细胞自动机的一种。
平面上的正方形格子皱填上黑色或白色。在其中一格正方形内有一只“蚂蚁”。
蚂蚁的头部朝向为:上下左右其中一方。
蚂蚁的移动规则十分简单:

若蚂蚁在黑格，右转90度， 将该格改为白格,并向前移一格;
若蚂蚁在白格，左转90度, 将该格改为黑格,并向前移一格。
规则虽然简单，蚂蚁的行为却十分复杂。刚刚开始时留下的路线都会有接近对称,像是会重复,但不论起始状态如何，蚂蚁经过漫长的混乱活动后，会开辟出一-条规则的“高速公路
蚂蚁的路线是很难事先预测的。

你的任务是根据初始状态,用计算机模拟兰顿蚂蚁在第n步行走后所处的位置。
[数据格式]
输入数据的第一行是m n两个整数(3 < m, n < 100)，表示正方形格子的行数和列数。
接下来是m行数据。
每行数据为n个被空格分开的数字。0表示白格，1表示黑格。
接下来是一行数据: x y s k,其中x y为整数，表示蚂蚁所在行号和列号(行号从上到下增长，列号从左到右增长，都是从开始编号)。
s是一个大写字母， 表示蚂蚁头的朝向，我们约定：上下左右分别用UDLR展示
 K表示蚂蚁走得步数
输出数据为两个空格分开的整数p q,分别表示蚂蚁在k步后,所处格子的行号和列号。

用户输入
3 3
0 0 0
1 1 1
1 1 1
1 1 U 6
结果
0 0
程序输入
5 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
2 3 L 5
结果 1 3

 */
public class _08兰顿蚂蚁 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //行数
        int n = sc.nextInt(); //列数

        //坐标就是一个二维数组
        int[][] g = new int[m][n]; //记录坐标
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = sc.nextInt();
            }

        }

        //x 行号   y列号   s蚂蚁的朝向    k蚂蚁走得步数
        int x = sc.nextInt();
        int y = sc.nextInt();
        String s = sc.next();
        int k = sc.nextInt();

        int d = toD(s); //反转前的方向

        int step = 0; //已经走的步数

        while (true){
            //若蚂蚁在黑格，右转90度， 将该格改为白格,并向前移一格;
            if (g[x][y] == 1) {
                d = d % 4 + 1; //旋转
                g[x][y] = 0;

            } else {
                //若蚂蚁在白格，左转90度, 将该格改为黑格,并向前移一格。
                d--; //左转
                if (d == 0) d = 4;
                g[x][y] = 1;
            }

            //前进
            if (d == 1) {
                x--; //向上
            } else if (d == 2) {
                y++; //向右
            } else if (d == 3) {
                x++; //向下
            } else if (d == 4) {
                y--; //向左
            }

            step++; //走了一步
            if (step == k){
                System.out.println(x+" "+y);
                break;
            }
        }


    }

    //将字母转化为数字，进行转换
    static int toD(String str) {

        //U  D  R   L
        if (str.equals("U")) return 1;
        if (str.equals("R")) return 2;
        if (str.equals("D")) return 3;
        if (str.equals("L")) return 4;
        return 0;
    }
}
