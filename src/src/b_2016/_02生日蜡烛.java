package src.b_2016;
/*
生日蜡烛
某君从某年开始每年都举办一次生日party,并且每次都要吹熄与年龄相同根数的蜡烛。
现在算起来，他一共吹熄了236根蜡烛。
请问，他从多少岁开始过生日party的?
请填写他开始过生日party的年龄数。
注意:你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

26
*/
//枚举 i  j
/*                 n(a1+an)      i+j              i+j                   j-i+1
等差数列的求和： = ----------  >  ------*n   ----> -------*(j-i+1)  ---->------*i+j
                    2             2                2                     2
 */

public class _02生日蜡烛 {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            int sum = 0;
            for (int j = i; j <= 100; j++) {

                //区间值
                sum += j;
                if (sum == 236){

                    System.out.println(i);
                }

              /*  if ((j - i + 1) / 2 * (i + j) == 236) {
                    System.out.println(i+" "+ j);
                }
*/
            }
        }
    }
}
