package src.c_2016;

import java.math.BigInteger;
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
//2:优化 超时问题
public class _08冰雹数_2 {
    static BigInteger ONE = BigInteger.ONE;
    static BigInteger TWO = BigInteger.valueOf(2);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
    }

    static BigInteger f(int x) {
        BigInteger[] buf = new BigInteger[x + 1];
        buf[0] = BigInteger.ZERO;
        buf[1] = BigInteger.valueOf(4);
        buf[2] = BigInteger.valueOf(4);

        for (int i = 3; i <= x; i++) {
            if (i % 2 == 0) {
                buf[i] = buf[i - 1];
                continue;
            }

            // i为奇数
            BigInteger max = buf[i - 1];
            BigInteger i_big =  BigInteger.valueOf(i);
            //变换之后数 如果不等于1 就继续变换
            while (i_big.compareTo(ONE) != 0){
                //更新max
                if (i_big.compareTo(max) == 1){
                    max = i_big;
                }
                if (i_big.compareTo(BigInteger.valueOf(i)) == -1 ){
                    break;
                }
                i_big = i_big.mod(TWO).equals(BigInteger.ZERO) ?
                        i_big.divide(TWO): //偶数
                i_big.multiply(BigInteger.valueOf(3)).add(ONE); //奇数
            }
            buf[i] = max;

        }
        return buf[x];
    }


}
