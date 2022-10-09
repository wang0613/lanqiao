package src;

import java.util.Scanner;

import static java.lang.Math.*;
/*
X星球的考古学家发现了一批古代留下来的密码。
这些密码是由A、B、C、D 四种植物的种子串成的序列。
仔细分析发现，这些密码串当初应该是前后对称的（也就是我们说的镜像串）。
由于年代久远，其中许多种子脱落了，因而可能会失去镜像的特征。

你的任务是：
给定一个现在看到的密码串，计算一下从当初的状态，它要至少脱落多少个种子，才可能会变成现在的样子。

输入一行，表示现在看到的密码串（长度不大于1000）
要求输出一个正整数，表示至少脱落了多少个种子。

例如，输入：
ABCBA
则程序应该输出：
0

再例如，输入：
ABECDCBABC
则程序应该输出：
3

资源约定：
峰值内存消耗 < 256M
CPU消耗 < 1000ms

请严格按要求输出，不要画蛇添足地打印类似：“请您输入…” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。

注意: main函数需要返回0
注意: 只使用ANSI C/ANSI C++ 标准，不要调用依赖于编译环境或操作系统的特殊函数。
注意: 所有依赖的函数必须明确地在源文件中 #include ， 不能通过工程设置而省略常用头文件。
 */
/*
首先输入字符串s，令i = 字符串开端，j = 字符串末尾，

如果 s[i] == s[j]那就i++ , j--.

如果 s[i] == s[j]两种办法: i 左边补上s[j], j--;  j 右边补上s[i] ，i++;

其实没必要真的去补，比如，i 左边补s[j]时，我们可以假设补上了，只需要让j--，i 不变
 */
public class 密码脱落 {

    static char[] chars;

    //左边坐标 和 右边坐标
    static int dfs(int left, int right) {

        while (chars[left] == chars[right]) {
            left++;
            right--;

            //出口
            if (left >= right) {
                return 0;
            }
        }

        //可以补给左边，或者右边，求最少的一个方法
        return min(dfs(left + 1, right) + 1, dfs(left, right - 1) + 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        chars = str.toCharArray();

        int dfs = dfs(0, chars.length-1);
        System.out.println("dfs = " + dfs);

    }

}
