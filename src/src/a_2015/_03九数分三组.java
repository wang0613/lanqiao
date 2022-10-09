package src.a_2015;

/*
九数分三组
1~9的数字可以组成3个3位数，设为: A,B,C，现在要求满足如下关系:
    B=2*A
    C=3*A
请你写出A的所有可能答案，数字间用空格分开，数字按升序排列。
注意:只提交A的值，严格按照格式要求输出。*/

//192 219 273 327
import java.util.Set;
import java.util.TreeSet;

//全排列
public class _03九数分三组 {

    static Set<Integer> set = new TreeSet<>();
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {

        f(0);

        System.out.println(set);
    }

    static void f(int k) {
        if (k == arr.length) {
            //数组抓换为数字     模拟A，B，C
            int A = arr[0] * 100 + arr[1] * 10 + arr[2];
            int B = arr[3] * 100 + arr[4] * 10 + arr[5];
            int C = arr[6] * 100 + arr[7] * 10 + arr[8];


            if (2 * A == B && 3 * A == C) {
                set.add(A);
            }
        }

        for (int i = k; i < arr.length; i++) {

            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            f(k + 1);

            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }

    }
}
