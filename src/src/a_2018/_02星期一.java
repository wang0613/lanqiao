package src.a_2018;

/*
标题:虽期一
整个20世纪(1901年1月1日至2000年12月31日之间)，一共有多少个星期一?
(不要告诉我你不知道今天是星期儿)
注意:需要提交的只是一个整数，不要填写任何多余的内容或说明文字。

 */
public class _02星期一 {
    public static void main(String[] args) {

        //判断是不是闰年 闰年366天
        int t = 0;
        for (int i = 1901; i <= 2000; i++) {

            if (isRunYear(i)) {
                t += 366;
            } else {
                t += 365;
            }
        }
        System.out.println(t/7);

        //12月31日星期日，为了防止跨两个星期天 -6
        t -= 6;
        int ans = 0;
        for (; t > 0; t -= 7) {
            ans++;
        }
        System.out.println(ans);



    }

    //是不是闰年
    public static boolean isRunYear(int year) {

        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
