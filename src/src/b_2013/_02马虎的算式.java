package src.b_2013;

/*
B组第2题
C组第3题
标题:马虎的算式

小明是个急性子，.上小学的时候经常把老师写在黑板 上的题目抄错了。
有一次，老师出的题目是: 36 x 495=?
他却给抄成了: 396x 45 = ?
但结果却很戏剧性，他的答案竟然是对的! !
因为36 * 495 = 396 * 45 = 17820
类似这样的巧合情况可能还有很多，比如: 27 * 594=  297 * 54
假设a b c d e代表1~9不同的5个数字(注意是各不相同的数字，且不含0)
能满足形如: ab * cde = adb * ce这样的算式一共有多少种呢?


请你利用计算机的优势寻找所有的可能，并回答不同算式的种类数。
满足乘法交换律的算式计为不同的种类，所以答案肯定是个偶数。
答案直接通过浏览器提交。  // 142
 */
//枚举5个数字，注意数字不能相同
public class _02马虎的算式 {
    static int ans=0;

    public static void main(String[] args) {


        for (int a = 1; a < 10; a++) {

            for (int b = 1; b < 10; b++) {
                if (a == b) continue;
                for (int c = 1; c < 10; c++) {
                    if (a == c || b == c) continue;
                    for (int d = 1; d < 10; d++) {
                        if (a == d || b == d || c == d) continue;
                        for (int e = 1; e < 10; e++) {
                            if (a == e || b == e || c == e || d == e) continue;
                            //ab * cde = adb * ce

                            if ((a * 10 + b) * (c * 100 + d * 10 + e) == (a * 100 + d * 10 + b) * (c * 10 + e)) {
                                ans++;
                            }

                        }
                    }
                }
            }

        }
        System.out.println(ans);
    }
}
