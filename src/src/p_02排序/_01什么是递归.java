package src.p_02排序;


public class _01什么是递归 {


    public static void main(String[] args) {
        //输出费布拉切
        for (int i = 1; i < 9; i++) {
            System.out.println(fib(i));

        }

        //求最大公约数
        System.out.println(gcc(15, 5));

    }

    static void f(int i) {
        if (i <= 0) return;
        f(i - 1);
        System.out.println(i);
    }

    /**
     * 求n的阶乘
     */
    static int f1(int n) {
        //出口
        if (n == 1) return 1;

        return n * f1(n - 1);
    }

    /**
     * 打印 i到j
     */
    static void f2(int i, int j) {
        if (i == j) return;
        System.out.println(i);

        f2(i + 1, j);
    }

    /**
     * 对数组中所有元素的求和
     */
    static int f3(int[] arr, int begin) {

//        if (begin == arr.length) return 0;
        if (begin == arr.length - 1) return arr[begin];

        //第一位加上 后面的
        return arr[begin] + f3(arr, begin + 1);
    }

    static int f4(int[] arr, int end) {
        if (end < 0) return 0;

        return arr[end] + f4(arr, end - 1);
    }

    //二分法
    static int f5(int[] arr, int begin, int end) {

        int mid = (begin + end) / 2;

        if (begin == end) return arr[begin];

        if (mid == begin) return arr[begin] + arr[end];

        //作弊右开
        return f5(arr, begin, mid - 1) + f5(arr, mid, end);

    }

    //反转字符
    static String reverse(String str, int end) {

        //最后一位
        if (end == 0)
            return "" + str.charAt(0);

        return str.charAt(end) + reverse(str, end - 1);
    }


    //裴波拉切数列：一种特殊得数组  1 1 2 3  5  8 13
    static int fib(int n) {
        //到达前两个 是 1 1
        if (n == 1 || n == 2) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    //求最大公约数
    public static int gcc(int a, int b) {

        if (b == 0) return a;

        return gcc(b, a % b);
    }

    //递归的形式 插入排序
    static void insertSort(int[] arr, int k) {
        if (k == 0) return;

        insertSort(arr, k - 1);
        int x = arr[k];
        int index = k - 1;
        while (index > -1 && x < arr[index]) {
            arr[index + 1] = arr[index];
            index--;
        }
        arr[index + 1] = x;


    }

    //插入排序
    static void fff(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;

            while (j > -1 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
    }


}
