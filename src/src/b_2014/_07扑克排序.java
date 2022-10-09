package src.b_2014;

/*
标题:扑克序列
A A 2 2 3 3 4 4，一共4对扑克牌。请你把它们排成行。

要求:两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。
请填写出所有符合要求的排列中，字典序最小的那个。

例如: 22AA3344 比A2A23344字典序小。当然，它们都不是满足要求的答案。

请通过浏览器提交答案。“A”定不要用小写字母a,也不要用“1”代替。字符间一定不要留空格。*/


//全排列+check
import java.util.HashSet;
import java.util.Set;

public class _07扑克排序 {
    static Set<String> strings = new HashSet<>();

    public static void main(String[] args) {
        char[] s = {'A', 'A', '2', '2', '3', '3', '4', '4'};

        f(s, 0);

        System.out.println(strings);
    }

    static void f(char[] a, int k) {
        if (k == a.length) {
            //值最小的判断
//        两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。
            check(a);
            return;

        }

        for (int i = k; i < a.length; i++) {
            char t = a[i];
            a[i] = a[k];
            a[k] = t;

            f(a, k + 1);

            t = a[i];
            a[i] = a[k];
            a[k] = t;
        }


    }

    static void check(char[] a) {
        //转换为String
        String str = new String(a);
        //值最小的判断
//        两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。

        //中间有一个代表 距离为2
        if (str.lastIndexOf('A') - str.indexOf('A') == 2 &&
                str.lastIndexOf('2') - str.indexOf('2') == 3 &&
                str.lastIndexOf('3') - str.indexOf('3') == 4 &&
                str.lastIndexOf('4') - str.indexOf('4') == 5) {
            strings.add(str);
        }

    }
}
