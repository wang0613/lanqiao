package src.a_2014;

/*

标题:六角填数
如图[1.png]所示六角形中，填入1~12的数字。

         1
     8  0   0   0
       *     0
     0  0   0    0
          3
使得每条直线上的数字之和都相同。

图中，已经替你填好了3个数字，请你计算星号位置所代表的数字是多少?
 */
//全排列1-12，除了138之外的数字
public class _06六角填数 {
    public static void main(String[] args) {

        int[] arr = {2, 4, 5, 6, 7, 9, 10, 11, 12};


        f(arr, 0);


    }

    static void f(int[] arr, int k) {
        if (k == arr.length) {
            check(arr);
            return;
        }


        for (int i = k; i < arr.length; i++) {

            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            f(arr, k + 1);

            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

        }

    }

    static void check(int[] arr) {
        int a = 1 + arr[0] + arr[3] + arr[5];
        int b = 1 + arr[1] + arr[4] + arr[8];
        int c = arr[5] + arr[6] + arr[7] + arr[8];


        int d = 8 + arr[0] + arr[1] + arr[2];
        int e = 8 + arr[3] + arr[6] + 3;
        int f = 3 + arr[7] + arr[4] + arr[2];
        if (a == b && b == c && c == d && d == e && e == f) {

            System.out.println(arr[3]);
        }

    }

}
