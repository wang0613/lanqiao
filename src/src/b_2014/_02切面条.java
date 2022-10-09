package src.b_2014;


import java.math.BigInteger;

/*
标题:切面条
一根高筋拉面，中间切一刀，可以得到2根面条。

如果先对折1次，中间切一刀，可以得到3根面条。

如果连续对折2次，中间切一刀，可以得到5根面条。

那么，连续对折10次，中间切一刀，会得到多少面条呢?

答案是个整数，请通过浏览器提交答案。不要填写任何多余的内容。
*/
public class _02切面条 {
    public static void main(String[] args) {

        // 2    3   5   9   17        ···········  x
        // 0    1   2   3   4         ············ 10
        //1+2^0 1+2^1 1+2^2 1+2^3 1+2^4          1+2^10

        BigInteger a = BigInteger.valueOf(2).pow(10).add(BigInteger.ONE);

        System.out.println(a); //1025

    }
}
