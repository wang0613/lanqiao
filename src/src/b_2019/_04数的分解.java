package src.b_2019;

/*
把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包 含数字 2 和 4，
一共有多少种不同的分解方法？

注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和 1001+1000+18 被视为同一种。

【答案提交】
这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

 */
public class _04数的分解 {
    static int ans;
    public static void main(String[] args) {
        for (int i = 1; i <= 2019; i++) {
            String a = String.valueOf(i);
            if (a.contains("2") || a.contains("4")) continue;

            for (int j = i+1; j <= 2019 ; j++) {
                String b = String.valueOf(j);
                if (b.contains("2") || b.contains("4")) continue;

                for (int k = j+1; k <= 2019; k++) {

                    String c = String.valueOf(k);
                    if (c.contains("2") || c.contains("4")) continue;

                    if (i+j+k == 2019){
                        ans++;
                        System.out.println(i +" " +j + " " + k);
                    }
                }

            }

        }

        System.out.println(ans);
    }
}
