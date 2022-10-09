package src.c_2019;

import java.util.Arrays;
import java.util.Scanner;

/*
F.旋转

【问题描述】

图片旋转是对图片最简单的处理方式之一，在本题中，你需要对图片顺时 针旋转 90 度。
 我们用一个 n×m 的二维数组来表示一个图片，例如下面给出一个 3×4 的 图片的例子：
1 3 5 7
9 8 7 6
3 5 9 7

旋转90度：
3 9 1
5 8 3
9 7 5
7 6 7
给定初始图片，请计算旋转后的图片。
【输入格式】
输入的第一行包含两个整数 n 和 m，分别表示行数和列数。
 接下来 n 行，每行 m 个整数，表示给定的图片。
 图片中的每个元素（像 素）为一个值为 0 至 255 之间的整数（包含 0 和 255）。

【输出格式】
输出 m 行 n 列，表示旋转后的图片


 */
public class _06旋转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //新数组
        int[][] new_arr = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                /*
                1 1--> 1 3
                1 2--> 2 3
                1 3--> 3 3
                1 4--> 4 3
                i j    j n-i+1
                 */
                new_arr[j][n - i + 1] = arr[i][j];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(new_arr[i][j] + " ");

            }
            System.out.println();


        }

    }
}
