package src.digui.p03;


public class Test1 {
    public static void main(String[] args) {

        String s = f("abc");

        System.out.println(s);
    }

    //反转字符串
    public static String f(String str) {

        if (str.length() <= 1){
            return str;
        }

        return f(str.substring(1))+str.charAt(0);

    }
}
