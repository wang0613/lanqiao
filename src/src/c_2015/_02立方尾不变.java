package src.c_2015;

/*

立方尾不变
有些数字的立方的末尾正好是该数字本身。
比如: 1,4,5,6,9,24,25,....
请你计算一下，在10000以内的数字中(指该数字，并非它立方后的数值)，符合这个特征的正整数一共有多少个。

请提交该整数，不要填写任何多余的内容。
*/

//36 int超出范围 必须使用long
public class _02立方尾不变 {
    static long ans = 0;

    public static void main(String[] args) {

        //最大数 9999*9999*9999
        for (long i = 1; i < 10000; i++) {
            long num = i * i * i;
            check2(num, i);

        }
        System.out.println(ans);

    }

    //截取尾串 进行比较
    static void check(long num, long i) {
        String str = num + "";
        String s = i + "";

        //i有多少位 截取多少位
        String substring = str.substring(str.length() - s.length());

        if (substring.equals(s)) {
            ans++;
        }

    }

    //简便写法，如果i是一位数大数 %10  就%100
    //i的长度最大为4位
    static void check2(long num, long i) {
        String a = i + "";
        long rs = 0;
        if (a.length() == 1) {
            rs = num % 10;
        } else if (a.length() == 2) {
            rs = num % 100;
        } else if (a.length() == 3) {
            rs = num % 1000;
        } else if (a.length() == 4) {
            rs = num % 10000;
        }

        //如果截取后的字符串和原来相同
        if (rs == i) {
            ans++;
        }

    }
}
