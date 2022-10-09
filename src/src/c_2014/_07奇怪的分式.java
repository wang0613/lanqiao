package src.c_2014;

/*
标题:奇怪的分式
上小学的时候，小明经常自己发明新算法。-次，老师出的题目是:
    1/4乘以8/5

小明居然把分子拼接在一起，分母拼接在起，答案是: 18/45 (参见图1 . png)
老师刚想批评他，转念一想，这个答案凑巧也对啊，真是见鬼!
对于分子、分母都是1~9 中的一位数的情况，还有哪些算式可以这样计算呢?
请写出所有不同算式的个数(包括题中举例的)
显然，交换分子分母后，例如: 4/1乘以5/8是满足要求的，这算做不同的算式。
但对于分子分母相同的情况，2/2乘以3/3这样的类型太多了，不在计数之列!
注意:答案是个整数(考虑对称性，肯定是偶数)。请通过浏览器提交。不要书写多余的内容。

14
 */
public class _07奇怪的分式 {
    public static void main(String[] args) {

        int ans = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if (a == b) {
                    continue;
                }
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        if (c == d) {
                            continue;
                        }
                        //约分 求最大公约数，然后相除
                        int g1 = gcd(a * c, b * d);//最大公约数
                        int g2 = gcd(a * 10 + c, b * 10 + d);

                        //两个分子的 除以公约数 是==
                        if ((a * c) / g1 == (a * 10 + c) / g2 && (b * d) / g1 == (b * 10 + d) / g2) {
                            ans++;
                        }
                    }
                }


            }


        }
        System.out.println(ans);




    }

    //约分 求最大公约数，然后相除
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b); // 4
    }
}
