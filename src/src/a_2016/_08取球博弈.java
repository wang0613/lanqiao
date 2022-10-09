package src.a_2016;

import java.util.Arrays;
import java.util.Scanner;

/*
取球博弈
两个人玩取球的游戏。
一共有N个球，每人轮流取球，每次可取集合{n1,n2,n3}中的任何一个数目。
如果无法继续取球，则游戏结束。
此时，持有奇数个球的一方获胜。
如果两人都是奇数，则为平局。

假设双方都采用最聪明的取法，
第一个取球的人一定能赢吗？
试编程解决这个问题。

输入格式：
第一行3个正整数n1 n2 n3，空格分开，表示每次可取的数目 (0<n1,n2,n3<100)
第二行5个正整数x1 x2 ... x5，空格分开，表示5局的初始球数(0<xi<1000)

输出格式：
一行5个字符，空格分开。分别表示每局先取球的人能否获胜。
能获胜则输出+，
次之，如有办法逼平对手，输出0，
无论如何都会输，则输出-

例如，输入：
1 2 3
1 2 3 4 5
程序应该输出：
+ 0 + 0 -
再例如，输入：
1 4 5
10 11 12 13 15
程序应该输出：
0 - 0 + +
再例如，输入：
2 3 5
7 8 9 10 11
程序应该输出：
+ 0 0 0 0


此题因为双方都采用最聪明的取法，所以先观察最聪明的取法：在保证能取得奇数的情况下，尽量取大数，
如果实在保证不了，直接取可取的最大数，双方都这样取，直到结束，比较取得总球数的奇偶性；
比如可取球数为1 2 3
总球数为5时  用A、B代表双方：A->3,B->1,A->1结束，A输；
总球数为8时  A->3,B->3,A->2结束，平局
总球数为9时 A->3,B->3,A->2,B->1,结束，A赢
 */
public class _08取球博弈 {
    static int[] n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = new int[3];
        for (int i = 0; i < 3; i++) {
            n[i] = sc.nextInt();

        }
        Arrays.sort(n); //排序

        String res = "";
        for (int i = 0; i < 5; i++) {
            //比对每一种情况
            int num = sc.nextInt();
            res += f(num, 0, 0) + " "; //递归

        }
        System.out.println(res.trim());
    }

    /**
     * 参数代表着取球人面临的局面
     * @param num 球的总数
     * @param me  我方的球数
     * @param you 对方的球数
     */
    private static char f(int num, int me, int you) {
        //不够 取，出口
        if (num < n[0]) {

            //若 我手中是奇数，对手手中是偶数，我赢了
            if (me % 2 != 0 && you % 2 == 0) {
                return '+';
            } else if (me % 2 == 0 && you % 2 != 0) {
                //若 我手中是偶数，对手手中是奇数
                return '-';
            } else {
                return '0';
            }

        }

        boolean ping = false; //是不是平均情况

        for (int i = 0; i < 3; i++) {
            //有三种局面 -1 -2 -3，
            if (num >= n[i]) {
                //博弈问题：身份互换
                char res = f(num - n[i], you, me + n[i]);
                //交换分身，如果对手输了，我就赢了
                if (res == '-') {
                    return '+';
                }
                //存在平局
                if (res == '0') {
                    ping = true;
                }
            }
        }
        //如果能走到这行，说明不存在 对手 输的情况，那么是否存在平局的情况，若不存在，那么我输了
        if (ping) {
            return '0';
        } else {
            //输了
            return '-';
        }
    }
}
