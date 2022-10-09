package src.digui.p01;


public class Test3 {
    public static void main(String[] args) {

//        boolean flag = isSameString("abc", "abcd");
//        System.out.println(flag);

        boolean f = f2("abc", "abcd");
        System.out.println("f = " + f);


    }

    //比较首字符字符串，进行截取，递归
    private static boolean f(String s1, String s2) {
        //如果踢皮球
        //1.如果两个字符串的长度都不相同，肯定不相同，
        if (s1.length() != s2.length()) {
            return false;
        }

        //判断空串，若果s1为空，s2必然为空
        if (s1.length() == 0/* && s2.length() == 0*/) {
            return true;
        }

        //2.判断首字符
        if (s1.charAt(0) != s2.charAt(0)) {
            return false;
        }

        //3. 截取字符串
        //使字符串 不断变短   变成空串 长度为 0 ，我们认为长度相同
        return f(s1.substring(1), s2.substring(1));
    }

    private static boolean f2(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.charAt(0) != s1.charAt(0)) return false;


        //使字符串 不断变短  知到一个字符串为null
        return f(s1.substring(1), s2.substring(1));
    }


    //不使用循环，和成品api 使用递归
    public static boolean isSameString(String s1, String s2) {


        return s1.equals(s2);

    }
}
