package src.c_2015;

/*
无穷分数
无穷的分数，有时会趋向于固定的数字。
请计算[图1. jpg]所示的无穷分数,要求四舍五入，精确到小数点后5位,小数位在足的补0。

         1
1+   ----------
         2
   2+-----------
          3
     3+---------
          4
     4+--------
          4+······


如果是1000层
              9999
      9999 + --------
             10000                1
       1000+--------  ---->   1+-----
            1000+1                f2

             n-1
Fn-1 = ------------
            n-1+fn


请填写该浮点数，不能填写任何多余的内容。*/
//0.58198

import java.math.BigDecimal;
import java.math.BigInteger;

public class _03无穷分数 {
    public static void main(String[] args) {
        BigDecimal fn = new BigDecimal(BigInteger.ONE);

        for (int i = 3000; i >= 1; i--) {

            BigDecimal n = new BigDecimal(BigInteger.valueOf(i));

            // n/n+fn
            fn = n.divide(n.add(fn), 6, BigDecimal.ROUND_HALF_UP);

        }
        System.out.println(fn.toString());

    }
}
