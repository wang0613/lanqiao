package src.c_2015;

import java.util.Scanner;

/*

打印大X
小明希望用星号拼凑，打印出一个大X，他要求能够控制笔画的宽度和整个字的高度。
为了便于比对空格，所有的空白位置都以句点符来代替。
要求输入两个整数m n, 表示笔的宽度，X的高度。用空格分开(0<m<n, 3<n<1000， 保证n是奇数)
要求输出一个大X
例如，用户输入:
3   9
程序应该输出:
***·····***
·***···***·
··***·***··
···*****···
····***····
···*****···
··***·***··
·***···***·
***·····***
 */
public class _09打印大X {
    static char[][] g;
    static int m, n, w; //m*号数量  n高度 w列数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        w = m + (n / 2) * 2; // 11

        g = new char[n][w]; //9,11

        //全部初始化为·
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                g[i][j] = '·';

            }

        }
        //从左上到右下 第一层控制每层的·数
        for (int i = 0; i < n; i++) {
            //先处理三个 \\ 后处理 //
            for (int k = 0; k < m; k++) {
                g[i][i + k] = '*';

            }
        }
        //从右上到左下
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //11-1-0-0 = 10
                //11--1-2-1 = 9
                g[i][w - i - j - 1] = '*';
            }
        }

        //输出变遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();

        }

    }
}
