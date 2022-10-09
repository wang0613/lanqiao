package src.b_2017;


public class _05取位数 {
    static int len(int x) {
        if (x < 10) return 1;
        return len(x / 10) + 1;

    }

    //取x的第k为
    static int f(int x, int k) {
        if (len(x) - k == 0) return x % 10;
        //不是k+ 就是 x减少位数
        //k已确定，不可能减少
        return f(x / 10, k); //填空题
    }

    public static void main(String[] args) {
        int x = 23513;
        System.out.println(len(x));
        System.out.println(f(x, 4));

    }
}
