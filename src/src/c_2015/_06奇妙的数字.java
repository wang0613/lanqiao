package src.c_2015;

import java.util.HashSet;
import java.util.Set;

/*

奇妙的数字
小明发现了一个奇妙的数字。它的平方和立方正好把0~9的10个数字每个用且只用了一次。
你能猜出这个数字是多少吗?
请填写该数字，不要填写任何多余的内容。

69
 */
public class _06奇妙的数字 {
    public static void main(String[] args) {

        for (int i = 1; i < 100000; i++) {
            long num1 = i * i;
            long num2 = num1 * i;

            if (check(num1, num2)) {

                System.out.println(i);

            }


        }




    }

    //检查只出现了一次
    static boolean check(long p, long l) {
        String s = p + "" + l;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));

        }

        //两个数字的长度是为10的
        return set.size() == 10 && s.length() == 10;

    }
}
