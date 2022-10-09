package src.c_2019;

import java.util.Scanner;

/*
人物相关性分析

【问题描述】

小明正在分析一本小说中的人物相关性。他想知道在小说中 Alice 和 Bob 有多少次同时出现。
更准确的说，小明定义 Alice 和 Bob“同时出现”的意思是：在小说文本 中 Alice 和 Bob 之间不超过 K 个字符。 例如以下文本：
This is a story about Alice and Bob.Alice wants to send aprivate message to Bob.
假设 K = 20，则 Alice 和 Bob 同时出现了 2 次，分别是”Alice and Bob” 和”Bob. Alice”。
前者 Alice 和 Bob 之间有 5 个字符，后者有 2 个字符。
注意: 1. Alice 和 Bob 是大小写敏感的，alice 或 bob 等并不计算在内。
 2. Alice 和 Bob 应为单独的单词，前后可以有标点符号和空格，但是不能 有字母。例如 Bobbi 並不算出现了 Bob。

【输入格式】
第一行包含一个整数 K。 第二行包含一行字符串，只包含大小写字母、标点符号和空格。长度不超 过 1000000。

【输出格式】
输出一个整数，表示 Alice 和 Bob 同时出现的次数。

【样例输入】
20
This is a story about Alice and Bob.Alice wants to send aprivate message to Bob
【样例输出】
2
 */
public class _08人物相关性分析 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        //换行问题.参考https://blog.csdn.net/zxfly6/article/details/80514903
        sc.nextLine();
        String str = sc.nextLine();
        //因为符号为两个字符所以把符号替换为任意两个字符以便于str通过split方法分割为数组
        str = str.replaceAll("\\.", " ab ");
        //以空格和.把句子分割成数组
        String[] strs = str.split("\\s+");
        //记录关联次数
        int count = 0;
        //累加Alice后k字符Bob出现的次数
        for (int i = 0; i < strs.length; i++) {
            //用于记录间隔字符
            int chars = 0;
            if (strs[i].equals("Alice")) {
                //检索此字符串后的单词
                for (int j = i + 1; j < strs.length; j++) {
                    if (strs[j].equals("Bob") && chars <= k) {
                        //记录
                        count++;
                    } else {
                        chars = chars + (j - i) + 1 + strs[j].length();
                    }
                }
            }
        }
        ////累加Bob后k字符Alice出现的次数
        for (int i = 0; i < strs.length; i++) {
            //用于记录间隔字符
            int chars = 0;
            if (strs[i].equals("Bob")) {
                for (int j = i + 1; j < strs.length; j++) {
                    if (strs[j].equals("Alice") && chars <= k) {
                        count++;
                    } else {
                        chars = chars + (j - i) + 1 + strs[j].length();
                    }
                }
            }
        }
        System.out.println(count);

    }
}
