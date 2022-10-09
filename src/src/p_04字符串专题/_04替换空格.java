package src.p_04字符串专题;

/*
编写一个方法将字符串中的空格全部替换为"%20"
给定一个str和length
 */
public class _04替换空格 {
    public static void main(String[] args) {

        System.out.println(replace1("ab c d00000000".toCharArray(), 4));

    }

    //1：可以使用字符串中的replaceAll方法，空格的regex是"\\s"
    static String replace(String str, int length) {
        return str.replaceAll("\\s", "%20");

    }

    static String replace1(char[] chars, int length) {
        int cnt = length;
        //先找出空格的数量，变长是数组 有一个空格，长度都需要+2
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                cnt += 2;
            }

        }
        int p1 = length - 1;
        int p2 = cnt - 1;
        while (p1 >= 0) {
            if (chars[p1] == ' ') {
                chars[p2--] = '0';
                chars[p2--] = '2';
                chars[p2--] = '%';
            }else {
                chars[p2--] = chars[p1];
            }
            p1--;
        }
        return new String(chars);

    }
}
