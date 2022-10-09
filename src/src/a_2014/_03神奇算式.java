package src.a_2014;

import java.util.Arrays;

/*
标题:神奇算式
由4个不同的数字，组成的一个乘法算式，它们的乘积仍然由这4个数字组成。
比如:
    210 * 6 = 1260
    8 * 473 = 3784
    27 * 81 = 2187
都符合要求。
如果满足乘法交换律的算式算作同一种情况，那么，包含上边已列出的3种情况，一共有多少种满足要求的算工
请填写该数字，通过浏览器提交答案，不要填写多余内容(例如:列出所有算式)。

 */
public class _03神奇算式 {
    static int ans = 0;

    public static void main(String[] args) {
        //枚举第一第一位不能为0
        for (int a = 1; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if (a == b) continue;
                for (int c = 0; c < 10; c++) {
                    if (c == a || c == b) continue;
                    for (int d = 0; d < 10; d++) {
                        if (d == a || d == b || d == c) continue;

                        int s_rs = a * 1000 + b * 100 + c * 10 + d;//组合串结果

                        if (b != 0) {
                            int rs = (a) * (b * 100 + c * 10 + d);//乘法结果
                            if (check(rs, s_rs)) {
                                ans++;
                            }
                        }

                        if (c != 0) {
                            int rs = (a * 10 + b) * (c * 10 + d);//乘法结果
                            if (/*((a * 10 + b) < (c * 10 + d)) && */check(rs, s_rs)) {
                                ans++;
                            }
                        }

                        if (d != 0) {
                            //插入*号
                            int rs = (a * 100 + b * 10 + c) * (d);//乘法结果
                            if (check(rs, s_rs)) {
                                ans++;
                            }
                        }


                    }

                }


            }

        }
        System.out.println(ans/2);


    }

    //如果判断两个位数不相等的数，是不是相等的？？？？
    //1:转字符数组，进行升序排列，进行equals()
    private static boolean check(int rs, int s_rs) {
        String s = rs + "";
        String s_r = s_rs + "";

        char[] chars1 = s.toCharArray();
        char[] chars2 = s_r.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return new String(chars1).equals(new String(chars2));
//        return Arrays.toString(chars1).equals(Arrays.toString(chars2));
    }


}
