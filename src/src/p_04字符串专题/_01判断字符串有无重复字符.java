package src.p_04字符串专题;


public class _01判断字符串有无重复字符 {
    public static void main(String[] args) {

        System.out.println(check("acsxwef"));
    }

    //判断字符串中是否有重复字符
    static boolean check(String str) {

        int[] flag = new int[128];
        for (int i = 0; i < str.length(); i++) {
            int c = (int) (str.charAt(i));

            if (flag[c] > 0) {
                return false;
            }else flag[c]++;
              //数组中指定位置元素变成1
        }
        return true;

    }
}
