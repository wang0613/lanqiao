package src.a_2017;

/*
标题: 9数算式

观察如下的算式:
9213 x 85674 = 789314562
左边的乘数和被乘数正好用到了1~9的所有数字，每个1次。
而乘积恰好也是用到了1~9的所有数字，并且每个1次。
请你借助计算机的强大计算能力，找出满足如.上要求的9数算式一共有多少个?
注意:
1.总数目包含题目给出的那个示例。
2.乘数和被乘数交换后作为同一-方案来看待。
请提交一个整数，不要填写任何多余内容或说明文字。
*/

import java.util.HashSet;
import java.util.Set;

//不重复的全排列 +结果判断
public class _02九数算式 {
    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    static int ans;

    public static void main(String[] args) {


        f(0);
        //没有考虑到  乘数和被乘数互换的情况，所以除以2
        System.out.println(ans / 2);
    }

    public static void f(int k) {

        if (k == a.length) {
            //枚举*号的位置   被乘数一位== arr.length-1
            for (int i = 1; i <= 8; i++) {
                //转化为int数字 0-i为乘数
                int num1 = toInt(a, 0, i);
                //第二个数字 从当前数字到结尾 为被乘数
                int num2 = toInt(a, i, 9);

                //使用set判断结果是不是具有唯一的
                if (check(num1 * num2)) {
                    ans++;
                }

            }
        }

        for (int i = k; i < a.length; i++) {
            int t = a[i];
            a[i] = a[k];
            a[k] = t;

            f(k + 1);

            t = a[i];
            a[i] = a[k];
            a[k] = t;

        }
    }

    //将数组区间的位数转换为数字
    public static int toInt(int[] arr, int begin, int end) {
        int t = 1;
        int res = 0;
        //从最后一位去数字（索引 ）
        for (int i = end - 1; i >= begin; i--) {
            res += arr[i] * t;
            t *= 10;

        }
        return res;

    }

    //检查结果是不是1-9只出现了一次 使用set去重
    public static boolean check(int num) {
        //使用set去重符
        Set<Character> set = new HashSet<>();

        String s = num + "";

        //如果结果的长度不是9 直接false
        //注意结果不能包含0
        if (s.length() != 9 || s.contains("0")) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));

        }
        return s.length() == set.size();
    }
}
