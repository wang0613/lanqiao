package src.p_03多维数组和矩阵;

/**
 * @author WANG_HAILONG
 * @version 1.0
 * @description:
 * @date 2021/5/28 15:26
 */
public class Test {


    public static void main(String[] args) {
        int x, y;//鸡的数量为x，兔的数量为y
        int head = 8 , foot = 26;//头的数量为head，脚的数量为foot



        if (foot % 2 == 0) {

            /*
            x+y=head
            2*x+4*y=foot

            x=2*head-foot/2
             */

            x = 2 * head - foot / 2;
            y = head - x;

            if (x >= 0 && y >= 0) {
                System.out.println("鸡的数量为：" + x + "，兔的数量为：" + y);
            }

        }



    }

}
