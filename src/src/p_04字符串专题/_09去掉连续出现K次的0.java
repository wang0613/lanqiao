package src.p_04字符串专题;


public class _09去掉连续出现K次的0 {
    public static void main(String[] args) {

        System.out.println(removeZero2("q000221", 3));

    }

    static String removeZero(String str, int k) {

        //移除字符串中连续出现的K个0
        String regex = "0{" + k + "}";

        return str.replaceAll(regex, "");
    }

    static String removeZero2(String str, int k) {
        char[] a = str.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '0') {
                count++;
            } else {

                for (int j = 0; j < count % k; j++) {
                    sb.append("0");
                }
                sb.append(a[i]);
                count = 0;
            }

        }
        for (int j = 0; j < count % k; j++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
