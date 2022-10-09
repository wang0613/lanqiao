package src.p_04字符串专题;

/*
aba

aba

 */
public class _10回文串 {
    public static void main(String[] args) {
        System.out.println(isSame("aba"));
    }

    static Boolean isSame(String str) {
        //反转后 和原来相同
        return str.equals(new StringBuilder(str).reverse().toString());

    }
}
