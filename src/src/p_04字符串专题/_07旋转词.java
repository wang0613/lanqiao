package src.p_04字符串专题;

/*
给定两个字符串，s1 s2要求判定能否通过s1做循环移位 得到s2
 */
public class _07旋转词 {
    public static void main(String[] args) {
        System.out.println(isRotate("abc", "acb"));


    }

    static boolean isRotate(String a, String b) {
       /* if (a.length() != b.length()){
            return false;
        }*/

        //b+b
        StringBuilder sb = new StringBuilder(b).append(b);

        //如果新的子串 包含a
        return sb.toString().contains(a);

    }
}
