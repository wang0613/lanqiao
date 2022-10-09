package src.p_04字符串专题;

import java.util.Arrays;

/*
给定两个字符串，请确定一个字符串变形之后，能否变成另一个字符串
 */
public class _03变形词问题 {
    public static void main(String[] args) {
        System.out.println(check("abc", "bac"));

    }

    /*
    给定两个字符串，确定一个字符串会变形之后，能不能变成另外一个字符串
     */
    static boolean check(String str1, String str2) {
        int len1  = str1.length();
        int len2  = str1.length();

        if (len1 != len2){
            return false;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);



        //两种方式都可以
//        return Arrays.equals(char1,char2);

        return new String(char1).equals(new String(char2));
    }
}
