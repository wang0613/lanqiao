package src.a_2018;

import java.math.BigInteger;

/*
i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。

答案写成 “实部±虚部i” 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。
(2+3i)^2 写成: -5+12i，
(2+3i)^5 的写成: 122-597i

注意：需要提交的是一个很庞大的复数，不要填写任何多余内容。
 */
public class _03复数幂 {
    public static void main(String[] args) {


        BigInteger a = new BigInteger("2");
        BigInteger b = new BigInteger("3");
        BigInteger c = new BigInteger("2");
        BigInteger d = new BigInteger("3");

        //复数的求和公式    a+bi)(c+di)=(ac-bd)+(bc+ad)i；
        for (int i = 2; i <= 123456; i++) {
            BigInteger t = a;
            a = a.multiply(c).subtract(b.multiply(d));
            b = t.multiply(d).add(b.multiply(c));
        }
        //控制台太小，打印不了，建议文件输出
//      FileWriter fw=new FileWriter("src/Step1/out.txt",true);
//      fw.write(a+(b.compareTo(BigInteger.ZERO)==1?"+":"")+b+"i");
        System.out.println(a + (b.compareTo(BigInteger.ZERO) == 1 ? "+" : "") + b + "i");
//      fw.flush();
    }
}
