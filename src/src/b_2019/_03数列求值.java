package src.b_2019;

import java.math.BigInteger;

/*
给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。
求 第 20190324 项的最后 4 位数字。

【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一 个 4 位整数（提示：答案的千位不为 0），在提交答案时只填写这个整数，填写 多余的内容将无法得分。

 */
public class _03数列求值 {
    public static void main(String[] args) {

        long a = 1;
        long b = 1;
        long c = 1;
        //试了一下long也能爆，还是取摸吧
        //前面三项已经有了，从第四项开始
        for (int i = 4; i <= 20190324; i++) {
            long temp = ((a + b + c) % 10000);
            a = b;
            b = c;//依次往后移
            c = temp;
        }
        System.out.println(c);
    }
}
