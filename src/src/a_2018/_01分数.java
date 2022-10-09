package src.a_2018;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
标题: 分数
1/1 +1/2 +1/4 + 1/8+ 1/16+....
每项是前一项的一半， 如果一共有20项,
求这个和是多少，结果用分数表示出来。
类似:
3/2
当然，这只是加了前2项而已。分子分母要求互质。
注意:
需要提交的是已经约分过的分数，中间任何位置不能含有空格。
请不要填写任何多余的文字或符号。

分母为 2^0  2^1 2^2····2^19

约分后
使用快速幂运算
 2^20-1 / 2^19

 */
public class _01分数 {
    public static void main(String[] args) {


        BigInteger bg = BigInteger.valueOf(2);

        BigInteger a = bg.pow(20).subtract(BigInteger.ONE);
        BigInteger b = bg.pow(19);

//        BigInteger gcd = a.gcd(b); //最大公约数
//        System.out.println(gcd);
        System.out.println(a+"/"+b);

        //没有公约数

    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

//    static long pow_2(int b) {
//        int x = 2;
//        int res = 1;
//        while (b > 0) {
//            if (b & 1) {
//                res *= x;
//            }
//            b >>= 1;
//            x = x * x;
//        }
//        return res;
//
//    }
}
