package src.a_2015;

import java.util.Scanner;

/*
移动距离
        X星球居民小区的楼房全是样的，并且按矩阵样式排列。 其楼房的编号为1,2,3...
        兰当非满一行时，从下一行相邻的楼往反方向排号。
        比如:当小区排号宽度为6时，开始情形如下:
        1 2 3 4 5 6
        12 11 10 9 8 7
        13 14 15

        我们的问题是:已知了两个楼号m和n，需要求出它们之间的最短移动距离(不 能斜线方向移动)
输入为3个整数w m n,空格分开，都在1到10000范围内

        w为排号宽度，m, n为待计算的楼号。

        要求输出一个整数，表示m n两楼间最短移动距离。
        例如:
        用户输入:
        6 8 2
        则，程序应该输出:
        4
        例如:
        用户输入:
        4 7 20
        则，程序应该输出:
        5

*/
public class _08移动距离 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt(); //每行数量

        int m = sc.nextInt(); // m楼
        int n = sc.nextInt(); //n楼


        /*
        1   2    3   4   5   6
        12  11   10  9   8   7
        13  14   15  16  17  18
         */

        int x1 = m % w == 0 ? m / w : m / w + 1; //求m所在的行号
        int x2 = n % w == 0 ? n / w : n / w + 1;//求n所在的行号


        int y1 = 0;//m所在列号
        int y2 = 0;//n所在列号

        //如果是偶数列，(从右到左开始的) x1*w - m+1
        // 2*6-8+1 = 5
        if (x1 % 2 == 0) {
            y1 = x1 * w - m + 1;
        } else {
            //如果是奇数列，(从左到右开始的) w-(x1*w -m)
            //例如求16 6-(3*6-16)=4
            y1 = w - (x1 * w - m);
        }

        if (x2 % 2 == 0) {
            y2 = x2 * w - n + 1;
        } else {
            y2 = w - (x2 * w - n);
        }

        System.out.println("m所在坐标\t"+x1+" "+y1);
        System.out.println("n所在做标\t"+x2+" "+y2);

        //结果例如: |x2-x1|+|y2-y1|
        System.out.println(Math.abs(x2-x1)+Math.abs(y2-y1));


    }
}
