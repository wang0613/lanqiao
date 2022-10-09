package src;

/*
Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。

当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。

余数 取模
 */
public class Fibonacci数列 {
    public static void main(String[] args) {

        System.out.println(f(22)%10007);


    }

    public static int f(int n) {
        if (n == 1 || n == 2) return 1;
        return f(n - 1) + f(n - 2);

    }
}
