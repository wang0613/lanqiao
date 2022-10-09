package src.a_2017;

import java.util.Scanner;

/*
描述:正则问题
考虑种简单的正则表达式:
    只由 x ( ) | 组成的正则表达式。
小明想求出这个正则表达式能接受的最长字符串的长度。
    例如((xx Ixx)xI(xIxx))xx能接受的最长字符串是: xxxxxx    长度是6。
输入
----
一个由 x ( ) | 组成的正则表达式。输入长度不超过100,保证合法。
输出
这个正则表达式能接受的最长字符串的长度。
例如，
输入:
    ((xx|xxx)x|(x|xx))xx
程序应该输出:
6

((xx|xxx)x|(x|xx))xx
     xxx x|xx xx
       xxx0x xx  6个

 */
public class _07正则问题 {

    static String s;
    static int len;
    static int pos;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        len = s.length();
        System.out.println(f());

    }

    public static int f() {
        int m = 0; //两个数的最大
        int tmp = 0; //临时x的数量

        while ( pos <len) {
            if (s.charAt(pos) == '(') {
                //继续前行
                pos++;
                tmp += f();//等待后面的结果，累加到temp
            } else if (s.charAt(pos) == 'x') {
                pos++;
                tmp++;
            } else if (s.charAt(pos) == '|') {
                pos++;

                //结算最大值(m记录着|前面的最大值，temp当前的最大值)
                m = Math.max(m, tmp);

                tmp = 0; //值为0 记录后面的x数量
            } else if (s.charAt(pos) == ')') {
                pos++;
                //结算最大值
                m = Math.max(m,tmp);
                return m;
            }
        }
        //计算总的最大值
        m = Math.max(m,tmp);
        return m;
    }
}
