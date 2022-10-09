package src.b_2013;

import java.util.Calendar;

/**
 * 第一题：
 * 1999年的12月31日是星期五
 * 未来哪一个离我们最近的世纪末年  (xx99)年的12月31日是星期天(星期日)
 * <p>
 * 2299年
 */
public class _01世纪末的星期 {
    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();

        for (int i = 1999; i < 10000; i += 100) {
            c.set(Calendar.YEAR,i);
            c.set(Calendar.MONTH,11);
            c.set(Calendar.DAY_OF_MONTH,31);


            if (c.get(Calendar.DAY_OF_WEEK) == 1){
                System.out.println(i);
                break;
            }
        }
    }
}
