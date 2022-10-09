package src.a_2015;


/*
循环节长度.

两个整数做除法，有时会产生循环小数，其循环部分称为:循环节。
比如，11/13=6=>0.846153846153.....其循环节为[846153] 共有6位。
下面的方法，可以求出循环节的长度。
请仔细阅读代码，并填写划线部分缺少的代码。
public static int f(int n，int m)
    n=n%m;
    Vector V = new Vector();
    for(;;)
    V. add(n);
    n *= 10;
    n=n%m;
if(n= =0) return 0;
if(v. index0f(n)>=0)___
; //填空
}
}
注意，只能填写缺少的部分，不要重复抄写已有代码。不要填写任何多余的文字。
*/

import java.util.Vector;

public class _04循环节长度 {
    public static void main(String[] args) {
        System.out.println(f(11,13)); //6

    }

    public static int f(int n, int m) {
        n = n % m;

        Vector V = new Vector();
        for (; ; ) {
            V.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) return 0;

            //运行发现，结束不了，需要return
            if (V.indexOf(n) >= 0) {
                //填空
                //使用debug发现，循环6次，是一个循环节
                //***坑点***
                return V.size()-V.indexOf(n);

            }

        }
    }

}
