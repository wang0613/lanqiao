package src.c_2015;

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
    static int w, m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        m = sc.nextInt(); //起始点
        n = sc.nextInt(); //目标点


        //求行号
        int hm = m % w == 0 ? m / w : (m / w) + 1;
        int hn = n % w == 0 ? n / w : (n / w) + 1;

        int lm= 0;
        int ln= 0;
        //求列号
        if (hm % 2 == 0) {
            //从右到左
            lm = (hm*w-m)+1;
        }else {
            lm = w-(hm*w-m);
        }

        //求列号
        if (hn % 2 == 0) {
            //从右到左
            ln = (hn*w-n)+1;
        }else {
            ln = w-(hn*w-n);
        }

        System.out.println(m+"所在坐标:"+hm+"  :  "+lm);
        System.out.println(n+"所在坐标:"+hn+"  :  "+ln);


        System.out.println(Math.abs(hm-hn)+Math.abs(lm-ln));
    }
}
