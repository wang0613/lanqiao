package src.c_2017;

import java.util.Arrays;
import java.util.Scanner;

/*
标题:承压计算
X星球的高科技实验室中整齐地堆放着某批珍贵金属原料。
每块金属原料的外形、尺寸完全一致，但重量不同。
金属材料被严格地堆放成金字塔形。

                7
               7 8
              7 8 9
             x x x x


其中的数字代表金属块的重量(计量单位较大)
最下一层的X代表30台极高精度的电子秤。
假设每块原料的重量都十分精确地平均落在下方的两个金属块上，
最后，所有的金属块的重量都严格精确地平分落在最底层的电子秤上。
电子秤的计量单位很小，所以显示的数字很大。
工作人员发现，其中读数最小的电子秤的示数为: 2086458231
请你推算出：读数最大的电子秤的示数为多少？
 */
public class _04承压计算 {

    static long[][] arr = new long[30][30];


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long factor = 1;//做2的30次方 看最后是不是最小电子秤的倍数
        for (int i = 0; i < 30; i++) {
            factor <<= 1;

        }

        //1:输入数据，放入二位数组
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j <= i; j++) {
                long a = sc.nextLong();
                arr[i][j] = a * factor;
                //每个数据都乘以factor

            }
        }
        //2:自上而下，处理 a[i][j]*f actor(2^30)--->除以2，计入a[i+1][j]和a[i][j+1]
        //3:循环处理第2~N-1行
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j <= i; j++) {
                long ha = arr[i][j] / 2; //每一个都除以2 加入下一行的同一列和下一行的下一列
                arr[i + 1][j] += ha;
                arr[i + 1][j + 1] += ha;

            }
        }


        //4:对a[N-1]这一行进行排序，查看最小值与factor之间的倍数关系，决定最大值是多少
        Arrays.sort(arr[29]);
        System.out.println(arr[29][0]); //最小的数
        System.out.println(arr[29][29]); //最大的数

        //最后的数是数值的2倍，需要除以2
        System.out.println(arr[29][29]/(arr[29][0]/2086458231));
    }
}
