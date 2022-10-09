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
public class _07外卖店优先级 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt(); //n家外卖
        int M = input.nextInt(); //行
        int T = input.nextInt(); //时刻
        //存放每个时刻对应的店铺
        List<Integer> [] arr= new ArrayList[T + 1];

        //存放优先级
        int better[] = new int[N + 1];
        //是不是在缓存中
        boolean level[] = new boolean[N + 1];

        //T时刻
        for (int i = 0; i <= T; i++) {
            arr[i] = new ArrayList<>();
        }
        //m行数据
        for (int i = 1; i <= M; i++) {
            int ts = input.nextInt(); //时刻
            int id = input.nextInt(); //店铺id
            arr[ts].add(id);    //t时刻有店铺id的订单，
        }

        //T时刻 N家外卖店
        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= N; j++) {
                int flag = 0;
                Object k = j;
                //如果当前点 有j 店铺id的订单
                while (arr[i].contains(k)) {
                    flag = 1;
                    //优先级+2
                    better[j] += 2;
                    //从数组中删除当前点 的订单
                    arr[i].remove(k);
                    //如果优先级大于5，当前店铺 进入缓存
                    if (better[j] > 5)
                        level[j] = true;
                }
                //此时刻无店铺j的订单
                if (flag == 0) {
                    //判断热度，如果没有 0 如果有-1
                    better[j] = better[j] == 0 ? 0 : better[j] - 1;

                    //如果当前店铺在缓存中
                    if (level[j]) {
                        //热度小于 3 清除缓存
                        if (better[j] <= 3) {
                            level[j] = false;
                        }
                    }
                }


            }

        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            //判断是不是在缓存中
            if (level[i])
                count++;
        }
        System.out.println(count);
    }
}
