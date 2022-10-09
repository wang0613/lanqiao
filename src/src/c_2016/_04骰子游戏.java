package src.c_2016;

/*
骰子游戏
我们来玩一任游戏。
同时掷出3个普通骰子(6个面.上的数字分别是1~6)。
如果其中一个骰子上的数字等于另外两个的和，你就赢了。
下面的程序计算出你能获胜的精确概率(以既约分数表示)

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int n = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                for (int k = 0; k < 6; k++) {
//                    if (=== )
                        n++; //填空位置
                }
        int m = gcd(n, 6 * 6 * 6);
        System.out.println(n / m + "/" + 6 * 6 * 6 / m);

    }
 */
public class _04骰子游戏 {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int n = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                for (int k = 0; k < 6; k++) {
                    //所有的数字都加上1
                    //i从0开始
//                    if (i+1 == j + k + 2 || j+1 == i + k + 2 || k+1 == i + j + 2)
                    if (i == j + k + 1 || j == i + k + 1 || k == i + j + 1)
                        n++; //填空位置
                }
        int m = gcd(n, 6 * 6 * 6); //最大公约数
        System.out.println(n / m + "/" + 6 * 6 * 6 / m); //鱼粉

    }
}
