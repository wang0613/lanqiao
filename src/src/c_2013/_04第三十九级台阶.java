package src.c_2013;

/*
 题目标题:第39级台阶
 小明刚刚看完电影《第39级台阶》，离开电影院的时候，他数了数礼堂前的台阶数，恰好是39级!
 站在台阶前，他突然又想着一个问题:
 如果我每一步只能迈上1个或2个台阶。先迈左脚，然后左右交替，最后一步是迈右脚，也就是说一共要走偶数步。
 那么，上完39级台阶， 有多少种不同的上法呢?

 请你利用计算机的优势，帮助小明寻找答案。
 要求提交的是一个整数。
 注意:不要提交解答过程，或其它的辅助说明文字。

 */
// f(n== 39) return f(n-1)+f(n-2) 最后的步数 记录下来
public class _04第三十九级台阶 {
    static int ans = 0;

    public static void main(String[] args) {
        f(39,0);
        System.out.println(ans); //51167078
    }

    /**
     * @param n    剩下的结题书
     * @param step 已经走得步数
     */
    public static void f(int n, int step) {

        if (n < 0) { //走完了
            return;
        }
        //如果走完，并且 步数最后是偶数 ++
        if (n == 0 && step % 2 == 0) {
            ans++;
            return;
        }

        f(n - 1, step + 1); //两种走法  走一步，或者走两步
        f(n - 2, step + 1);

    }
}
