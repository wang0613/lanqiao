package src.b_2015;

import java.util.Scanner;

/*
饮料换购
乐羊羊饮料厂正在举办一次促销优惠活动。乐羊羊C型饮料，凭3个瓶盖可以再换一瓶C型饮料， 并且可以一直循环下去(但不允许暂借或赊账)
请你计算一下，如果小明不浪费瓶盖，尽量地参加活动，那么，对于他初始买入的n瓶饮料，最后他一共能喝到多少瓶饮料。
    输入:一个整数n,表示开始购买的饮料数量(0<n<10000)
    输出:一个整数，表示实际得到的饮料数
例如:
用户输入:
100
程序应该输出:
149

用户输入:
101
程序应该输出:
151

 */
public class _08饮料换购 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        while (n >= 3) {
            //每当有3瓶饮料，n需要减掉2瓶，
            n -= 2;
            ans += 3; //每次都是有三瓶水
        }
        //加水最后剩余的一瓶水
        ans += n;
        System.out.println(ans);
    }
}
