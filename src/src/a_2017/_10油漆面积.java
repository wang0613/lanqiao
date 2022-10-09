package src.a_2017;


/*
X星球的一批考古机器人正在一片废墟上考古。
　　该区域的地面坚硬如石、平整如镜。
　　管理人员为方便，建立了标准的直角坐标系。

　　每个机器人都各有特长、身怀绝技。它们感兴趣的内容也不相同。
　　经过各种测量，每个机器人都会报告一个或多个矩形区域，作为优先考古的区域。

　　矩形的表示格式为(x1,y1,x2,y2)，代表矩形的两个对角点坐标。

　　为了醒目，总部要求对所有机器人选中的矩形区域涂黄色油漆。
　　小明并不需要当油漆工，只是他需要计算一下，一共要耗费多少油漆。

　　其实这也不难，只要算出所有矩形覆盖的区域一共有多大面积就可以了。
　　注意，各个矩形间可能重叠。

　　本题的输入为若干矩形，要求输出其覆盖的总面积。
输入格式
　　第一行，一个整数n，表示有多少个矩形(1<=n<10000)
　　接下来的n行，每行有4个整数x1 y1 x2 y2，空格分开，表示矩形的两个对角顶点坐标。
　　(0<= x1,y1,x2,y2 <=10000)
输出格式
　　一行一个整数，表示矩形覆盖的总面积面积。
样例输入
3
1 5 10 10
3 1 20 20
2 7 15 17
样例输出
340
样例输入
3
5 2 10 6
2 7 12 10
8 1 15 15
样例输出
128
 */

//暴力枚举
import java.util.Scanner;
public class _10油漆面积 {

    //坐标轴最大值
    //int会超出内存限制，使用boolean占用内存较小
    static boolean[][] p = new boolean[10005][10005];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt(),
                    y1 = sc.nextInt(),
                    x2 = sc.nextInt(),
                    y2 = sc.nextInt();
            //将输入的每一个图形打上马赛克
            paint(x1, y1, x2, y2);

        }
        //扫描总图
        int ans = 0;
        for (int i = 0; i < 10005; i++) {
            for (int j = 0; j < 10005; j++) {
                if (p[i][j]){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }

    //将输入的每一个矩形面积打上 马赛克，计算总的马赛克面积
    public static void paint(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {

                p[i][j] = true;
            }

        }
    }
}
