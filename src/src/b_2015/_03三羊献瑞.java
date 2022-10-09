package src.b_2015;

/*
/*
三羊献瑞
观察下面的加法算式:
     详 瑞 生 辉
   + 三 羊 献 瑞
---------------
  三 羊 生 瑞 气
(如果有对齐问题，可以参看[图1.jpg] )
其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。
请你填写“三羊献瑞”所代表的4位数字(答案唯-)，不要填写任何多余内容。

ans = 1085
 */


/*
    a   b   c   d
 +  e   f   g   b
 -----------------
 =e f   c   b   h

 */

//枚举八位数字 a e 不能为0
public class _03三羊献瑞 {
    public static void main(String[] args) {
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                if (a == b) continue;
                for (int c = 0; c < 10; c++) {
                    if (c == a || c == b) continue;
                    for (int d = 0; d < 10; d++) {
                        if (d == a || d == b || d == c) continue;

                        for (int e = 1; e < 10; e++) {
                            if (e == a || e == b || e == c || e == d) continue;

                            for (int f = 0; f < 10; f++) {
                                if (f == a || f == b || f == c || f == d || f == e) continue;
                                for (int g = 0; g < 10; g++) {
                                    if (g == a || g == b || g == c || g == d || g == e || g == f) continue;

                                    for (int h = 0; h < 10; h++) {
                                        if (h == a || h == b || h == c || h == d || h == e || h == f || h == g)
                                            continue;
                                        /*
                                            a   b   c   d
                                         +  e   f   g   b
                                         -----------------
                                         =e f   c   b   h

                                         */
                                        //第一个数字
                                        int num1 = a * 1000 + b * 100 + c * 10 + d;
                                        int num2 = e * 1000 + f * 100 + g * 10 + b;
                                        int num3 = e * 10000 + f * 1000 + c * 100 + b * 10 + h;
                                        if (num1 + num2 == num3) {
                                            System.out.println(num1 + "\t" + num2 + "\t" + num3);
                                        }

                                    }


                                }

                            }


                        }


                    }

                }

            }

        }


    }

    //使用技巧处理
    static void f(){
         /*
            a   b   c   d
         +  e   f   g   b
         -----------------
       =e   f   c   b   h
e =1, a= 9,f=0,c=b+1,c+g>10
*/

    }
}
