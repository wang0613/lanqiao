package src.c_2013;

/*
标题:组素数
素就是不能再进行等分的数。比如: 2 3 5 7 11等。
9=3*3说明它可以3等分，因而不是素数。
我们国家在1949年建国。如果只给你1 9 4 9这4个数字卡片，可以随意摆放它们的先后顺序(但卡片不能倒着摆放啊，我们不是在脑筋急转弯! )，
那么，你能组成多少个4位的素数呢?
比如: 1949，4919 都符合要求。

请你提交:能组成的4位素数的个数，不要罗列这些素数!!
注意:不要提交解答过程，或其它的辅助说明文字。
*/

import java.util.HashSet;
import java.util.Set;

//有重复元素的全排列
public class _02素数 {
    public static void main(String[] args) {
        int[] arr = {1, 9, 4, 9};
        f(arr, 0);
        System.out.println(set.size());

        set.forEach(System.out::println);


    }

    //1 9 4 9
    //处理从key开始的排列(全排列)
    static void f(int[] arr, int k) {

        //到达边界
        if (k == arr.length) {

            check(arr);
        }

        for (int i = k; i < arr.length; i++) {
            //交换位置
            int t = arr[k];
            arr[k] = arr[i];
            arr[i] = t;

            f(arr, k + 1);  //继续调换下一位

            //换回来 回溯
            t = arr[k];
            arr[k] = arr[i];
            arr[i] = t;

        }


    }

    static Set<Integer> set = new HashSet<>();

    //检查是不是素数
    private static void check(int[] arr) {
        //转换为整数
        int x = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];

        boolean flag = true;

        //判定是不是素数    开根号x
        for (int i = 2; i <= Math.sqrt(x); i++) {

            if (x % i == 0) {
                //不是素数
                flag = false;
                break;
            }

        }
        //是素数
        if (flag) {
            set.add(x);
        }
    }


    /**
     * 判断是否为素数/质数的常规方法
     * 判断n是否为素数，根据定义直接判断从2到n-1是否存在n的约数即可
     *
     * @param num 需要判断的数
     * @return flag
     */
    public static boolean isPrimaryNum(int num) {
        for (int i = 2; i < num; i++) {
            if (num % 2 == 0) return true;

        }
        return false;

    }


}
