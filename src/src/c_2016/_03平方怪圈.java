package src.c_2016;
/*


平方怪圈
如果把一个正整数的每位都平方 后再求和， 得到一个新的正整数 。
对新产生的正整数再做同样的处理。
如此一来，你会发现，不管开始取的是什么数字，
最终如果不是落入1,就是落入同一个循环圈。
请写出这个循环圈中最大的那个数字。
请填写该最大数字。
白注意:你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

*/


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _03平方怪圈 {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        int start = 3;

        for (int i = 0; i < 1000; i++) {

            int[] wei = f(start); //将数中提取出来 放入数组
            int sum = 0;
            for (int j = 0; j < wei.length; j++) {
                //做每一位的平方和
                sum += wei[j] * wei[j];


            }
            start = sum;
            set.add(sum);

        }
        System.out.println(Collections.max(set));


    }

    //将i的各个位转换为数组
    private static int[] f(int i) {
        String str = i + "";
        int[] a = new int[str.length()];
        for (int j = 0; j < str.length(); j++) {
            a[j] = str.charAt(j) - '0';
        }
        return a;

    }
}
