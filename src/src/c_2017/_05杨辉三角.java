package src.c_2017;

/*
标题:杨辉三角
杨辉三角也叫帕斯卡三角，在很多敬量关系中可以看到，十分重要
第0行:      1
第1行:     1 1
第2行:    1 2 1
第3行:   1 3 3 1
第4行:  1 4 6 4 1
两边的元素都是1，中间的元素是左 上角的元素与右上角的元素和。
我们约定，行号，列号都从0计数。
所以:第6行的第2个元素是15， 第3个元素是20
直观地看，需要开辟个二 维数组， 其实一维数组也可以胜任。
如下程序就是用维数组“腾挪”的解法 。

 */
public class _05杨辉三角 {

    //杨辉三角形的第row行第col列
    static long f(int row, int col) {
        if (row < 2) return 1;
        if (col == 0) return 1;
        if (col == row) return 1;

        long[] a = new long[row + 1];

        a[0] = 1;
        a[1] = 1;
        int p = 2;
/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1   //当前的元素等于 上一行的n个数+上一行的n-1
 */
        while (p <= row) {
            a[p] = 1;
            //填空位置
            for (int q = p - 1; q >= 1; q--)
                a[q] = a[q] + a[q - 1];
            p++;
        }
        return a[col];
    }

    public static void main(String[] args) {
        System.out.println(f(6, 2));
        System.out.println(f(6, 3));

    }
}
