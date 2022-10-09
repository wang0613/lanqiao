package src.c_2013;

import java.util.HashSet;
import java.util.Set;

/*
标题:猜年龄
美国数学家维纳(N. Wiener)智力早熟，11岁就上了大学。 他曾在1935-1936年应邀来中国清华大学讲学。
-次,他参加某个重要会议，年轻的畸孔引人注目。于是有人询问他的年龄,他回答说:

“我年龄的立方是个4位数。我年龄的4次方是个6位数。这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次。 ”
请你推算一下， 他当时到底有多年轻。

通过浏览器， 直接提交他那时的年龄数字。
注意:不要提交解答过程，或其它的说明文字。
int li = i * i * i;   4
int ci = li * i;      6

（s-li+s-ci）.length == 10 保证唯一 

 */
public class _01猜年龄 {
    public static void main(String[] args) {
        for (int i = 11; i < 100; i++) {

            //枚举
            int li = i * i * i;
            int ci = li * i;

            String s_li = li + "";
            String s_ci = ci + "";

            if (s_li.length() == 4 && s_ci.length() == 6 && checkAge(s_li + s_ci)) {
                System.out.println(i);
            }

        }


    }

    //校验只出现一次
    private static boolean checkAge(String str) {

        //可以使用set保证唯一
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));

        }
        return set.size() == 10;

//        char[] chars = new char[str.length()];
//        for (int i = chars.length-1; i >= 0; i--) {
//
//            int i1 = i - 1 ;
//
//            if (i1 > 0 &&str.charAt(i) == str.charAt(i1)) {
//                return false;
//            }
//        }
//        return true;
    }
}
