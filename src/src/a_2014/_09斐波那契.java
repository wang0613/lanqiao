package src.a_2014;

import java.util.Scanner;

/*
斐波那契数列大家都非常熟悉。它的定义是：

　　f(x) = 1 .... (x=1,2)
　　f(x) = f(x-1) + f(x-2) .... (x>2)

　　对于给定的整数 n 和 m，我们希望求出：
　　f(1) + f(2) + ... + f(n) 的值。但这个值可能非常大，所以我们把它对 f(m) 取模。
　　公式如下



　　但这个数字依然很大，所以需要再对 p 求模。
输入格式
　　输入为一行用空格分开的整数 n m p (0 < n, m, p < 10^18)
输出格式
　　输出为1个整数，表示答案
样例输入
2 3 5
样例输出
0
样例输入
15 11 29
样例输出
25
 */
//f(n)=f(n+1)-f(n-1)
//Σf(n)=f(n+2)-1
public class _09斐波那契 {
    static long n, m, p;

    public static void main(String[] args) {

        long i, n, m, p, a, b, c, fm, sn, result;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();


        a = b = 1;
        for (i = 3; i <= m; i++)//求fm
        {
            c = a + b;
            a = b;
            b = c;
        }
        fm = b;
        a = b = 1;
        for (i = 3; i <= n + 2; i++)//求sn
        {
            if (a + b >= fm)
                c = (a + b) % fm;
            else
                c = a + b;
            a = b;
            b = c;
        }
        sn = (b + fm - 1) % fm;


        result = sn % p;

        System.out.println(result);
    }
}
