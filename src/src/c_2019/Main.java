package src.c_2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
外卖店优先级

【问题描述】
“饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。
每家外卖店都有 一个优先级，初始时 (0 时刻) 优先级都为 0。
 每经过 1个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减 到 0；
 而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
 如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；
 如果 优先级小于等于 3，则会被清除出优先缓存。
 给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优 先缓存中。

【输入格式】
第一行包含 3 个整数 N、M 和 T。
以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到 一个订单。

【输出格式】
输出一个整数代表答案。
【样例输入】
2 6 6
1 1
5 2
3 1
6 2
2 1
6 2
【样例输出】
1
 */
//可以使用List数组表示 当前点和店铺
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //n家外卖店
        int M = sc.nextInt(); //m条数据
        int T = sc.nextInt(); //当前时刻

        //存放时刻 对应的店铺id
        List<Integer>[] arr = new ArrayList[T + 1];
        //优先级
        int[] better = new int[N + 1];
        //是不是在缓存中
        boolean[] huan = new boolean[N + 1];

        for (int i = 1; i <= T; i++) {
            arr[i] = new ArrayList<>();

        }
        //处理输入
        for (int i = 1; i <= M; i++) {
            int ts = sc.nextInt(); //当前时刻
            int id = sc.nextInt();  //店铺id

            arr[ts].add(id); //当前时刻，有订单的id店铺
        }

        //遍历
        for (int i = 1; i <= T; i++) {
            for (int d = 1; d <= N; d++) {
                boolean flag = false; //有没有订单

                Object k = d;
                //如果当前时刻从 有店铺 有订单
                while (arr[i].contains(k)) {
                    flag = true;
                    better[d] += 2;
                    arr[i].remove(k); //删除当前点 店铺
                    if (better[d] > 5) {
                        huan[d] = true;
                    }

                }
                //没有订单
                if (flag == false) {
                    //热度为0 吗
                    better[d] = better[d] == 0 ? 0 : better[d] - 1;

                    //是不是在缓存中
                    if (huan[d]){
                        //热度小于3
                        if (better[d] <= 3){
                            huan[d] = false;
                        }
                    }

                }


            }

        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (huan[i]){
                count++;
            }

        }
        System.out.println(count);


    }
}
