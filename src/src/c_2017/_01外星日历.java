package src.c_2017;

import java.math.BigInteger;

/*
某星系深处发现了文明遗迹。
他们的计数也是用十进制。
他们的文明也有日历。日历只有天数，没有年、月的概念。
有趣的是，他们也使用了类似“星期”的概念,
    只不过他们的一个星期包含了9天,
    为了方便，这里分别记为: A,B,C....H,I
从一些资料上看到,
    他们的 23 日是星期 E
    他们的 190 日是星期 A
    他们的 343251 日是星期 I
令人兴奋的是，他们居然也预见了“世界末日”的那天,
当然是一个很大很大的数字
651764141421415346185
请你计算一下，这遥远的一天是该文明的星期几?

 */
public class _01外星日历 {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("651764141421415346185");


        //取余
        BigInteger b = bigInteger.mod(BigInteger.valueOf(9));
        System.out.println(b.toString());

        //7 对应的是G

    }
}
