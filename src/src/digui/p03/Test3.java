package src.digui.p03;

//计算3个A，2个B可以组成多少种排列的问题？？？
public class Test3 {
    public static void main(String[] args) {

        System.out.println(f(3, 2));
    }

    //计算m个A n个B可以组成多少种排列？
    public static int f(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        //平地起风雷法(究极递归)
        //分两个阵营
        //
        return f(m - 1, n) + f(m, n - 1);

    }

}
