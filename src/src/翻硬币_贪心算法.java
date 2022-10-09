package src;

/*
小明正在玩一个“翻硬币”的游戏。

桌上放着排成一排的若干硬币。我们用 * 表示正面，用 o 表示反面（是小写字母，不是零）。

比如，可能情形是：**oo***oooo

如果同时翻转左边的两个硬币，则变为：oooo***oooo

现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,那么对特定的局面，最少要翻动多少次呢？

我们约定：把翻动相邻的两个硬币叫做一步操作，那么要求：

输入格式
两行等长的字符串，分别表示初始状态和要达到的目标状态。每行的长度<1000

输出格式
一个整数，表示最小操作步数。

样例输入1
**********
o****o****
样例输出1
5
样例输入2
*o**o***o***
*o***o**o***
样例输出2
1
 */
import java.util.Scanner;
public class 翻硬币_贪心算法 {

    static String in;//输入的字符串
    static String out;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        in = sc.nextLine();
        out = sc.nextLine();

        char[] in_chars = in.toCharArray();
        char[] out_chars = out.toCharArray();

        for (int i = 0; i < in.length(); i++) {
            if (in_chars[i] != out_chars[i]) {
                if (in_chars[i] == '*') {
                    in_chars[i] = 'o';
                } /*else {
                    in_chars[i] = 'o';
                }*/
                if (in_chars[i + 1] == '*') {
                    in_chars[i + 1] = 'o';
                } /*else {
                    in_chars[i + 1] = 'o';
                }*/
                ans++;
            }

        }
        System.out.println(ans);

    }
}
