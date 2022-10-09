package src;

/*

让你上n级的楼梯，每次可以走1，2，3级，3种选择，那么走到n级一共有几种组合

 */
public class 走梯子 {
    public static void main(String[] args) {

        System.out.println(f(6));

    }

    static int f(int n) {
        if (n < 0) return 0;
        if (n == 1) return 1;
        if (n== 2)return 2;

        return f(n - 1) + f(n - 2) + f(n - 3);
    }
}
