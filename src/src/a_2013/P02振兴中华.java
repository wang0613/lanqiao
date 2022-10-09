package src.a_2013;

/**
 * 小明参加趣味运动会，其中有一个就是跳格子
 * <p>
 * 从 我 做 起 振
 * 我 做 起 振 兴
 * 做 起 振 兴 中
 * 起 振 兴 中 华
 *
 * 有多少种路线可以走完振兴中华
 */
public class P02振兴中华 {

    public static void main(String[] args) {
        int rs = f(0, 0);
        System.out.println(rs); //35
    }

    // i为行数   j为列数
    private static int f(int i, int j) {

        //走到了边界
        if (i == 3 || j == 4) return 1;

        return f(i + 1, j) + f(i, j + 1);//满足两种路线的增加
    }
}
