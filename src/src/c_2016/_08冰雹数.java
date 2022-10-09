package src.c_2016;

import java.util.Scanner;

/*

冰雹数
任意给定一个正整数N,

    如果是偶数，执行:N/2
    如果是奇数，执行: N*3 + 1
生成的新的数字再执行同样的动作，循环往复。
通过观察发现，这个数字会一会儿上升到很高，
-会儿又降落下来。
就这样起起落落的，但最终必会落到“1”
这有点像小冰雹粒子在冰雹云中翻滚增长的样子。
比如N=9
9,28,14,7 ,22,11,34,17 ,52,26,13，40,20,10,5,16,8,4,2,1
可以看到，N=9的时候，这个“小冰雹”最高冲到了52这个高度。
输入格式:
一个正整数N (N<1000000)
输出格式:
一个正整数，表示大于0的数字，经过冰雹变换过程中，最高冲到了多少？

例如输入：
10
样例输出：
52

在例如输入：
100
样例输出：
9232
 */
//坑1：输入10，求的是1-9中每一个数冲到的最高度
public class _08冰雹数 {
    static int N;
    static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //本题求的是1-N中 冲击最高点的哪一个
        for (int i = 1; i <= N; i++) {
            long res = f(i);
            ans = Math.max(res, ans);

        }
        System.out.println(ans);


    }

    //求出当前i中 小冰雹最大数字
    private static long f(int i) {
        long max = -1;
        //求当前数中最大数
        while (i != 1) {
            max = Math.max(max, i);

            if (i % 2 == 0) {
                i /= 2;
            } else {
                i = i * 3 + 1;
            }

        }
        return max;

    }


}
