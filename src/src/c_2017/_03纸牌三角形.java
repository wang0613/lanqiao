package src.c_2017;

/*
标题:纸牌三角形
A,2,3,4,5,6,7,8,早共9张纸牌排成-个正三角形(A按1计算)。要求每个边的和相等。
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
public class _03纸牌三角形 {

    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int ans;

    public static void main(String[] args) {

        f(arr, 0);
        System.out.println(ans/6);//144
        //如果考虑旋转、镜像后相同的算同-种，每6中排列就算一种结果

    }

    //全排列
    public static void f(int[] arr, int k) {
        if (k == arr.length){
            //校验
            int x = arr[0]+arr[5]+arr[7]+arr[1];
            int y = arr[0]+arr[8]+arr[3]+arr[2];
            int z = arr[2]+arr[6]+arr[4]+arr[1];

            if (x == y && y==z){
                ans++;
            }


        }

        for (int i = k; i < arr.length; i++) {

            int t = arr[k];
            arr[k] = arr[i];
            arr[i] = t;

            f(arr, k + 1);

            t = arr[k];
            arr[k] = arr[i];
            arr[i] = t;


        }

    }
}
