package src;

import java.util.Set;
import java.util.TreeSet;

/*　
1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
输出格式
        　　按从小到大的顺序输出满足条件的四位十进制数。*/
public class 回文数 {

    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) {

        //求1000-9999之间的回文数

        for (int i = 1000; i <= 9999; i++) {
            String str = i + "";
            if (isSame(str)) {
                set.add(str);
            }

        }
        for (String arg : set) {
            System.out.println(arg);
        }
//        palindromeNum();


    }

    static boolean isSame(String str) {
        if (str.length() == 0) {
            return false;
        }
        return str.equals(new StringBuilder(str).reverse().toString());
    }


    //可以使用枚举 ij  i*1000+j*100+j*10+i都是回文数
    static void palindromeNum() {
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(i*1000+j*100+j*10+i);

            }

        }
    }
}
