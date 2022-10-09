package src.c_2017;

import java.util.Scanner;

/*
标题:拉马车
小的时候，你玩过纸牌游戏吗?
有一种叫做“拉马车”的游戏，规则很简单，却很吸引小朋友。
其规则简述如下: I
假设参加游难的小朋友是A和B，游戏开始的时候，他们得到的随机的纸牌序列如下:

A方:[K，8，X，K，A,2，A,9，5，A]
B方:[2，7，K,5，J，5，Q，6，K，4]

其中的X表示“10”，我们忽略了纸牌的花色。

从A方开始，A、B双方轮流出牌。

当轮到某一方出牌时，他从自己的纸牌队列的头部拿走一张，放到桌上，并且压在最，上面一张纸牌上(如果有的话)

此例中，游戏过程:
A出K，B出2, A出8, B出7, A出X，此时桌，上的序列为:

K, 2, 8, 7, X

当轮到B出牌时，他的牌K与桌上的纸牌序列中的K相同，则把包括K在内的以及两个K之间的纸牌都赢回来，放入自己牌的队尾。
注意:为了操作方便，放入牌的顺序是与桌上的顺序相反的。

赢牌的一方继续出牌。也就是B接着出5, A出K， B出J，A出A, B出5，又赢牌了。
5,K,J,A,5

此时，A、B双方的手里牌为:
A方:[K,A,2,A，9，5，A]
B方:[5,J，5，Q,6,K,4,K，X,7,8,2,K]

注意:更多的时候赢牌的一方并不能把桌上的牌都赢走，而是拿走相同牌点及其中间的部分。
但无论如何，都是赢牌的一方继续出牌，有的时候刚一出牌又赢了，也是允许的。

当某一方出掉手里最后一张牌，但无法从桌面上赢取牌时，游戏立即结束。
对于本例的初始手牌情况下，最后A会输掉，而B最后的手里牌为:
    9K2A62KAX58K57KJ5
本题的任务就是已知双方初始牌序，计算游戏结束时，赢的一方手里的牌序。当游戏无法结束时，输出-1。
输入为2行，2个串，分别表示A、B双方初始手里的牌序列。
输出为1行，1个串， 表示A先出牌，最后赢的一方手里的牌序。
例如，
输入:
96J5A898QA
6278A7Q973
则程序应该输出:
    2J9A7QA6Q6889977
再比如，
输入:
25663K6X7448
J88A5KJXX45A
则程序应该输出:
    6KAJ458KXAX885XJ645
我们约定，输入的串的长度不超过30
资源约定:
峰值内存消耗(含 虚拟机) < 256M
CPU消耗1 < 1000ms

 */
public class _08拉马车 {

    static StringBuilder A;//a的牌
    static StringBuilder B;//b的牌
    static StringBuilder C = new StringBuilder();//桌面上的牌

    /**
     * 操作的方法
     *
     * @param x 玩家手中牌
     * @param z 桌面上的牌
     * @return
     */
    static boolean op(StringBuilder x, StringBuilder z) {
        if (x.length() == 0) return false; //玩家手中没有牌

        boolean ans = true;

        //取玩家手中第一张牌
        char front = x.charAt(0);

        //桌面上有没有相同的牌
        int i = z.indexOf(front + "");

        //找到了
        if (i != -1) {
            //将这张牌，插入玩家的尾部，
            x.append(front);
            //并将桌面上的0-i之间的牌插入玩家的尾部
            for (int j = 0; j <= i; ++j) {
                //获取桌上的牌，依次插入
                x.append(z.charAt(j));
            }
            //从桌面上 移除这些牌  末尾是需要排除在外的所以需要+1
            z.delete(0, i+1);

        } else {
            //没有找到，将这张牌上放到 桌面上
            z.insert(0, front);
            ans = false;
        }
        //从手中 删除放到桌面的字符
        x.deleteCharAt(0); //删除手上的第一位

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        A = new StringBuilder(a);//a的牌
        B = new StringBuilder(b);//b的牌

        boolean flagA = true;  //A出牌的标志
        boolean flagB = false; //B出牌的标志

        while (true) {
            if (flagA) {
                flagA = op(A, C);
                if (A.length() == 0) {
                    System.out.println(B);
                    break;
                }
                //没有合成牌 false
                flagB = !flagA;

            }
            if (flagB) {
                flagB = op(B, C);
                if (B.length() == 0) {
                    System.out.println(A);
                    break;
                }
                flagA = ! flagB;
            }
        }

    }
}
