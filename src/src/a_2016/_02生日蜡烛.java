package src.a_2016;

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
/*                 n(a1+an)      i+j              i+j                   j-i-1
等差数列的求和： = ------ ----  >  ------*n   ----> -------*(j-i-1)  ---->------*i+j
                    2             2                2                     2
 */
public class _02生日蜡烛 {
    public static void main(String[] args) {

        //i ka是的年纪
        for (int i = 1; i <= 100; i++) {
            //现在的年纪
            for (int j = i; j <= 100; j++) {

                if ((i + j) * (j - i + 1) / 2 == 236) {
                    System.out.println(i + " " + j);
                }

            }

        }

        //2: 枚举生日的举办次数 n
        for (int i = 1; i < 100; i++) {
            //后一项
            int t =i * (i - 1) / 2;

            if ((236 - t) % i == 0) {
                //输出首项
                System.out.println((236 - t) / i);
            }

        }

    }
}
