package src.b_2017;

/*
标题:纸牌三角形
A,2,3,4,5,6,7,8,早共9张纸牌排成由一个正三角形(A按1计算)。要求每个边的和相等。
下图就是一种排法(如有对齐问题，参看p1. png)。
    A
   9 6
 4    8
3 7  5 2
这样的排法可能会有很多。
如果考虑旋转、镜像后相同的算同一种，一共有 多少种不同的排法呢?
请你计算并提交该数字。
注意:需要提交的是一个整数， 不要提交任何多余内容。

 */
public class _02纸牌三角形 {
    static int ans;

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        dfs(arr, 0);

        System.out.println(ans / 6);

    }

    private static void dfs(int[] arr, int i) {
        if (i == arr.length) {
            //校验
            int x = arr[0] + arr[5] + arr[7] + arr[1];
            int y = arr[0] + arr[8] + arr[3] + arr[2];
            int z = arr[2] + arr[6] + arr[4] + arr[1];

            if (x == y && y == z) {
                ans++;
            }

        }

        for (int j = i; j < arr.length; j++) {

            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;

            dfs(arr, i + 1);

            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
