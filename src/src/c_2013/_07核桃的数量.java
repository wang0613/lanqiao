package src.c_2013;

import java.util.Scanner;

/*
标题:核桃的数量
小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃(据传言能补脑)
    1.各组的核桃数量必须相同
    2.各组内必须能平分核桃(当然是不能打碎的)
    3.尽量提供满足 1，2条件的最小数量(节约闹革命嘛)
程序从标准输入读入:
    a b c
    a,b, c 都是正整数，表示每个组正在加班的人数，用空格分开(a,b,c<30)
程序输出:
    一个正整数，表示每袋核桃的数量。
例如:
用户输入:
    2 4 5
程序输出：
    20
再例如：
用户输入：
    3 1 1
程序输出：
    3
 */
//必须保证每袋核桃的数量 能够被整除
public class _07核桃的数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();


        //枚举的最大范围是 每个组人数的乘积
        for (int i = 1; i <= a * b * c; i++) {
            //如果能够同时满足三个组的条件
            if (i % a == 0 && i % b == 0 && i % c == 0) {
                System.out.println(i);
                break;
            }
        }

    }
}
