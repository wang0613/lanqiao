package src.java_2018;

/*
标题:哪天返回
小明被不明势力劫持。后莫名其妙被扔到x星站再无问津。小明得知每天都有飞船飞往地球，但需要108元的船票，而他却身
他决定在x虽战打工。好心的老板答应包食宿，第1天给他1元钱。
并且，以后的每一天都比前一天多2元钱，直到他有足够的钱买票。
请计算一下，小明在第几天就能凑够108元，返回地球。
要求提交的是一个整数，表示第几天。请不要提交任何多余的内容。

 */
public class _03哪天返回 {
    public static void main(String[] args) {

        int m = 1; //钱
        int day = 1;
        int total = m;//总钱
        while (total < 108) {
            m += 2; //每一天的钱 多两元
            day++;
            total += m;    //加上每一天的钱
            System.out.println(day+"  "+m+"   "+total);
        }
        System.out.println(day);


        System.out.println("---------------");
        int d = 1;
        int t = 1;
        for (int i = 1; i < 108; i+=t) {

            t += 2;
            d++;
        }
        System.out.println(d);

    }
}
