package src.b_2013;

/**
 * 小明参加趣味运动会，其中有一个就是跳格子
 * <p>
 * 从 我 做 起 振
 * 我 做 起 振 兴
 * 做 起 振 兴 中
 * 起 振 兴 中 华
 * <p>
 * 有多少种路线可以走完振兴中华
 */
public class _03振兴中华 {
    public static void main(String[] args) {

        System.out.println(f(0, 0));

    }

    public static int f(int m, int n) {
        if (m == 3 || n == 4) {
            return 1;

        }
        return f(m + 1, n) + f(m, n + 1);

    }
}
