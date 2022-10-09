package src.a_2017;

/*
最大公共子串的长度是多少？？？


    static int f(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] a = new int[c1.length + 1][c2.length + 1];
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                if (c1[i - 1] == c2[j - 1]) {

               a[i][j] = ------；//填空位置
                    if (a[i][j] > max) max = a[i][j];
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int n = f("abcdkkk", "baabcdadabc");
        System.out.println(n);

    }
 */
public class _06最大公共子串 {


    static int f(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] a = new int[c1.length + 1][c2.length + 1];
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                if (c1[i - 1] == c2[j - 1]) {

                    a[i][j] = a[i - 1][j - 1] + 1;//填空位置
                    if (a[i][j] > max) max = a[i][j];
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        String n = ff("abcdkkk", "baabcdadabc");
        System.out.println(n);

    }

    //使用暴力法排列
    public static String ff(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return null;
        }
        String max = "";
        String min = "";

        if (s1.length() > s2.length()) {
            max = s1;
            min = s2;
        } else {
            max = s2;
            min = s1;
        }
        for (int i = 0; i < min.length(); i++) {

            for (int begin = 0, end = min.length() - i; end <= min.length(); begin++, end++) {
                String curr = min.substring(begin, end);
                if (max.contains(curr)) {
                    return curr;
                }

            }

        }
        return null;

    }
}
