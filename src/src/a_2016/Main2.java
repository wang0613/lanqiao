package src.a_2016;

import java.util.Scanner;

/*
有N个瓶子，编号 1 ~ N，放在架子上。

比如有5个瓶子：
2 1 3 5 4

要求每次拿起2个瓶子，交换它们的位置。
经过若干次后，使得瓶子的序号为：
1 2 3 4 5

对于这么简单的情况，显然，至少需要交换2次就可以复位。

如果瓶子更多呢？你可以通过编程来解决。

输入格式为两行：
第一行: 一个正整数N（N<10000）, 表示瓶子的数目
第二行：N个正整数，用空格分开，表示瓶子目前的排列情况。

输出数据为一行一个正整数，表示至少交换多少次，才能完成排序。

例如，输入：
5
3 1 2 5 4

程序应该输出：
3

再例如，输入：
5
5 4 3 2 1

程序应该输出：
2

资源约定：
峰值内存消耗 < 256M
CPU消耗  < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 */
//因为都是从0开始的，依次遍历，查找位置交换位置
public class Main2 {
    static int n;
    static int[] a;
    static int ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();

        }
        //遍历1-N
        for (int i = 1; i <= n; i++) {
            if (a[i] == i) {
                continue;
            } else {
                //查找当前元素的位置   查找i位置   和当前的i位数字交换
                swap(pos(i),i);
                ans++;
            }

        }
        System.out.println(ans);

    }

    static void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;

    }
    static int pos(int k){
        for (int i = 1; i <= n; i++) {
            if (a[i] == k){
                return i;
            }

        }
        return -1;
    }
}
