package src.a_2015;

/*
牌型种数
小明被劫持到X赌城，被迫与其他3人玩牌。

一副扑克牌(去掉大小王牌，共52张)，均匀发给4个人， 每个人13张。
这时，小明脑子里突然冒出一个问题:

如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢?
请填写该整数，不要填写任何多 余的内容或说明文字。
*/

//3598180
public class _07牌型种数 {
    static int ans;

    public static void main(String[] args) {

//        f(0, 0);

//        System.out.println(ans);
        f1();
    }

    static void f(int k, int ctn) {
        //超出边界
        if (k > 13 || ctn > 13) {
            return;
        }
        //出口
        if (k == 13 && ctn == 13) {
            ans++;
            return;
        }
//        dfs的深度是牌的类型，每种牌可以选0~4种，选的牌的总数相加==13.....
        //逐步考虑牌形 出现 01234的次数
        for (int i = 0; i < 5; i++) {
            f(k + 1, ctn + i);

        }

    }

    static void f1() {


        int sum = 0;
        for (int a = 0; a <= 4; a++)
            for (int b = 0; b <= 4; b++)
                for (int c = 0; c <= 4; c++)
                    for (int d = 0; d <= 4; d++)
                        for (int e = 0; e <= 4; e++)
                            for (int f = 0; f <= 4; f++)
                                for (int g = 0; g <= 4; g++)
                                    for (int h = 0; h <= 4; h++)
                                        for (int i = 0; i <= 4; i++)
                                            for (int j = 0; j <= 4; j++)
                                                for (int k = 0; k <= 4; k++)
                                                    for (int l = 0; l <= 4; l++)
                                                        for (int m = 0; m <= 4; m++) {
                                                            if (a + b + c + d + e + f + g + h + i + j + k + l + m == 13)
                                                                sum++;
                                                        }
        System.out.println(sum
        );

    }


}
