package src.p_04字符串专题;


public class _08按单词反转字符串 {
    public static void main(String[] args) {
        String s1 = reverseString("here are you");
        //切割单词
        String[] split = s1.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(reverseString(split[i]+" "));
        }
        //最后一个空格
        sb.deleteCharAt(sb.length()-1);


        System.out.println(sb);

    }

    //反转字符串
    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();

    }
}
