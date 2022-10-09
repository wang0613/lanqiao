package src.a_2015;

/*星系炸弹
在X星系的广袤空间中漂浮着许多X星人造“炸弹”，用来作为宇宙中的路标。
每个炸弹都可以设定多少天之后爆炸。

比如:阿尔法炸弹2015年1月1日放置，定时为15天，则它在2015年1 月16日爆炸。

有一个贝塔炸弹，2014年11月9日放置，定时为1000天，请你计算它爆炸的准确日期。

请填写该日期，格式为yyyy-mm-dd 即4位年份2位月 份2位日期。比如: 2015-02-19

白请严格按照格式书写。不能出现其它文字或符号。
*/

//2017-08-05
import java.util.Calendar;

public class _02星系炸弹 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2014);
        c.set(Calendar.MONTH, 10);
        c.set(Calendar.DAY_OF_MONTH, 9);

        //添加1000天
        c.add(Calendar.DAY_OF_MONTH,1000);


        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));//month+1
        System.out.println(c.get(Calendar.DAY_OF_MONTH));

        //2017-08-05

    }
}
