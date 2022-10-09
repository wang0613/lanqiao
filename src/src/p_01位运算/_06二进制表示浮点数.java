package src.p_01位运算;




public class _06二进制表示浮点数 {
    public static void main(String[] args) {

        double num = 0.625;

        StringBuilder sb = new StringBuilder("0.");


        while (num > 0) {
            //挪整数
            double r = num * 2;
            if (r >= 1) {
                sb.append(1);

                //消除整数的部分
                num = r - 1;
            } else {
                sb.append(0);
                num = r;
            }
            if (sb.length() > 34) {
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sb.toString());


    }
}
