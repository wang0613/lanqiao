package src.digui.p03;

/**
 * 杨辉三角
 */
public class Test2 {
    public static void main(String[] args) {

        //打印杨辉三角的第m层 第n个数
/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1   //当前的元素等于 上一行的n个数+上一行的n-1
 */
        System.out.println(f(3,3));

    }

    //m是行数  n是每行的个数
    public static int f(int m, int n) {

        //因为m等于1时，只有一个1
        if (m == 0) {
            return 1;
        }

        //第一个数 都是1
        if (n == 0 || n == m) {
            return 1;
        }


        //当前的元素等于== 上一行的n+上一行的n-1
        return f(m - 1, n) + f(m - 1, n - 1);
    }
}
