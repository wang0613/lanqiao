package src.p_04字符串专题;


import java.util.HashMap;
import java.util.Map;

public class _06判断两个穿的字符集是否相同 {

    public static void main(String[] args) {
        System.out.println(check("abcd", "abc"));
    }

    static boolean check(String s1, String s2) {
        Map<Character, Integer>  map = new HashMap<>();


        //扫描s1
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.get(c) == null) {
                map.put(c,1);
            }

        }
        //扫描s2
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            //说明key不在列表中
            if (map.get(c) == null) {
                return false;
            }

        }


        return true;

    }

    // 如，传递的参数为 "abcdef" 和"defg"
    public static String getMaxSubString(String maxString, String minString) {
        String max = null;
        String min = null;

        max = maxString.length() > minString.length() ? maxString : minString;
        min = maxString.equals(max) ? minString : maxString;


        int minLength = min.length();

        if (max.contains(min)) {
            return min;
        }

        for (int i = 0; i < minLength; i++) {
            for (int start = 0, end = minLength - i; end <= minLength; start++, end++) {

                String temp = min.substring(start, end); //截取的那个。
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }
        return null;
    }

}
