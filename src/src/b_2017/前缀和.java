package src.b_2017;

/*


什么是前缀和?
两个数组x 和 y，满足
y0 = x0;
y1 = x0+x1;
y2 = x0+x1+x2;
…
y [ n ] = x [1] +x [2]+… x[ n ];


例子：
x  1    2   3   4   5   6
y  1    3   6   10  15  21      yn = yn-1+xn
 */
public class 前缀和 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        f(arr);

    }

    //前缀和
    public static void f(int[] arr) {
        int[] result = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            //第一个
            if (i == 0) {
                result[i] = arr[i];
            } else {
                //yn = yn-1+xn
                result[i] = result[i - 1] + arr[i];
            }


        }

//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//
//        }
    }
}
