package src.p_04字符串专题;

/*
请实现一个算法：反转给定的一个字符串
abcd

dcba
 */
public class _02反转字符串 {
    public static void main(String[] args) {
        System.out.println(reverse2("abvqqaa"));
    }

    static String reverse(String str) {
        char[] chars = str.toCharArray();

        char[] ch = new char[chars.length];
        int index = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            ch[index++] = chars[i];


        }
        return new String(ch);


    }

    static String reverse2(String str) {

        int len = str.length();

        char[] ch = new char[len];

        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(len-1-i);

        }

        return new String(ch);


    }
}
