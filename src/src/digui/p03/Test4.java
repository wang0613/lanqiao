package src.digui.p03;


public class Test4 {
    public static void main(String[] args) {
        int[] a = new int[1000];

        f(6, a, 0);
    }

    //对n进行加法划分

    //a是一个缓冲 如果是10 就是10个1相加
    // k表达当前的位置
    static void f(int n, int[] a, int k) {

        if (n <= 0) {
            for (int i = 0; i < k; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        //5   f(1)
        //4   f(2)
        for (int i = n; i > 0; i--) {
            if (k > 0 && i > a[k - 1]) continue;
            a[k] = i;
            f(n - 1, a, k + 1);

        }

    }


}
