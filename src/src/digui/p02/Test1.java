package src.digui.p02;

import java.util.Arrays;

/*经典递归问题：
平地起风雷(究极递归)

abc --->ab ac bc 在已知形式的
 */
public class Test1 {
    public static void main(String[] args) {

        int k = f(10, 3);

        System.out.println(k);

    }

    //在n个球中任意取出m个(不放回) 有多少种不同取法？
    public static int f(int n, int m) {
        //在已知球数的时候，可以使用循环枚举，进行枚举
        //此时n和m是不确定的

        //如果n<m，无法取出
        if (n < m) {
            return 0;
        }
        //如果n==m，只能够取出一次
        if (n == m) {
            return 1;
        }
        //如果 取出0个，只有一种方案
        if (m == 0){
            return 1;
        }

        //n个中有一个特殊球x，将所有的取法进行划分：包不包含x
        //包含x       使用f(n-1,m-1)
        //不包含x          使用f(n-1,m)
        return f(n - 1, m - 1) + f(n - 1, m);

    }

}
