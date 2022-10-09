package src.b_2017;

import java.util.Scanner;
import java.util.TreeSet;

/*
标题:日期问题
小明正在整理一批历史文献。 这些历史文献中出现了很多8期。小明知道这些日期都在1960年1月18至2059年12月31日
令小明头疼的是，这些日期采用的格式非常不统一，有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。
更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应，
比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。
给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗?
输入
一个日期，格式是"AA/BB/CC"。 (O <= A, B, C <= 9)
输入
输出若干个不相同的日期，每个日期-行，格式是"yyy-M-dd".多个日期按从早到晚排列。
样例输入
02/03/04

 */
public class _07日期问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        int a = 0, b = 0, c = 0;
        a = (in.charAt(0) - '0') * 10 + (in.charAt(1) - '0');
        b = (in.charAt(3) - '0') * 10 + (in.charAt(4) - '0');
        c = (in.charAt(6) - '0') * 10 + (in.charAt(7) - '0');

        String case1 = yan(a, b, c);
        String case2 = yan(c, a, c);
        String case3 = yan(c, b, a);

        TreeSet<String> strings = new TreeSet<>();

        if (!case1.equals("")) strings.add(case1);
        if (!case2.equals("")) strings.add(case2);
        if (!case3.equals("")) strings.add(case3);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    static String yan(int a, int b, int c) {
        if (a >= 0 && a <= 59) a += 2000;
        else if (a >= 60 && a <= 99) a += 1900;
        else return "";

        if (b < 1 || b > 12) return "";
        if (c < 1 || c > 31) return "";


        switch (b) {

            case 2:
                if (leap(a) && c > 29) return "";
                else if (!leap(a) && c > 28) return "";
                break;
            case 4:
                if (c > 30) return "";
                break;
            case 6:
                if (c > 30) return "";
                break;
            case 9:
                if (c > 30) return "";
                break;
            case 11:
                if (c > 30) return "";
                break;
            default:
                break;
        }

        String _A = a + "", _B = b + "", _C = c + "";
        if (_B.length() == 1) {
            _B = "0" + _B;
        }
        if (_C.length() == 1) {
            _C = "0" + _C;
        }

        return _A + "-" + _B + "-" + _C;
    }

    static boolean leap(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
