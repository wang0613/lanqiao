package src.b_2015;

/*
九数组分数
1,2,3...9这九个数字组成一个分数，其值恰好为1/3,如何组法?
下面的程序实现了该功能，请填写划线部分缺失的代码。
 */

//典型的全排列  需要补齐回溯
public class _05九数组分数 {
    public static void main(String[] args) {

        int []arr ={1,2,3,4,5,6,7,8,9};
        f(arr,0);

    }

    static void test(int[] x) {
        int a = x[0] * 1000 + x[1] * 100 + x[2] * 10 + x[3];
        int b = x[4] * 10000 + x[5] * 1000 + x[6] * 100 + x[7] * 10 + x[8];
        if (a * 3 == b) {
            System.out.println(a + "\t" + b);
        }
    }

    static void f(int[] x, int k) {
        if (k >= 9) {
            test(x);
            return;

        }
        for (int j = k; j < 9; j++) {
            { int t = x[k];x[k] = x[j];x[j] = t; }

            f(x, k + 1);


            //填空位置 (全排列回溯代码)
            { int t = x[k]; x[k] = x[j]; x[j] = t; }
        }
    }
}


