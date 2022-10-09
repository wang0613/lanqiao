package src.c_2015;

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

import java.util.Scanner;

//思路使用二维数组，初始化为·
//1：先处理从左上到右下的***
//2：再次处理从右上到左下***
public class Main {
    static int m, n, w;
    static char[][] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt(); //3
        n = scanner.nextInt(); //9
        w = m + (n / 2) * 2; //11位  9/2*2+3 = 12

        g = new char[n][w];

        //初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                g[i][j] = '·';

            }
        }

        //从左上到右下
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][i+j] = '*';

            }
        }
        //从右上到左下
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][w-1-i-j] = '*';
            }
        }
        //输出
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();

        }


    }
}
