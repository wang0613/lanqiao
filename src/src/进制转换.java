package src;

/*
问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。

输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。

输出格式
　　输出n行，每行为输入对应的八进制正整数。

　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。

样例输入
　　2
　　39
　　123ABC

样例输出
　　71
　　4435274

　　【提示】
　　先将十六进制数转换成某进制数，再由某进制数转换成八进制
 */
public class 进制转换 {
    public static void main(String[] args) {

//        f6(123);
        int i = Integer.parseInt("39", 16);//转化为二进制

        String string = Integer.toString(i, 8); //二进制转换为八进制
        System.out.println(string);


    }

    //转换为16进制
    public static void f(int i) {
        char result;
        if (i >= 0 && i <= 15) {
            if (i > 9) {
                result = (char) ('A' + (i - 10));
            } else {
                result = (char) ('0' + (i - 0));
            }

        }


    }

    //输入16进制 转换为 10 进制
    public static void f2(char c) {
        //0-9
        if (c >= 48 && c <= 57) {
            System.out.println(c);
        } else if (c >= 97 && c <= 102) {
            //偏移量    +10
            System.out.println("c   " + (c - 'a' + 10));
        } else if (c >= 65 && c <= 70) {
            System.out.println("c   " + (c - 'A' + 10));
        }

    }

    //将输入的任意整数   转换为16进制    123             7B
    public static void f3(int num) {
        int yu = num % 16; //余数  超过9的转换为a-f
        int shang = num / 16;  //商

        String hex = "";

        char rs;
        if (yu > 9) {
            rs = (char) ('A' + (yu - 10));
        } else {
            rs = (char) ('0' + (yu - 0));

        }
        hex += rs;

        yu = shang % 16; //得到余数 继续转换
//        shang = shang / 16; //商继续除以16   得

        //判断商是否为0
        if (yu > 9) {
            rs = (char) ('A' + (yu - 10));
        } else {
            rs = (char) ('0' + (yu - 0));
        }
        hex = rs + hex;
        System.out.println(hex);
    }

    //将输入的任意整数   转换为16进制
    public static void f4(int num) {
        String hex = "";
        int shang = num;
        int yu = 0;
        while (shang != 0) {
            yu = shang % 16; //余数  超过9的转换为a-f
            shang = shang / 16;  //商
            char rs;
            if (yu > 9) {
                rs = (char) ('A' + (yu - 10));
            } else {
                rs = (char) ('0' + (yu - 0));
            }
            hex = rs + hex;
        }
        System.out.println(hex);
    }

    //十进制 --》二进制
    public static void f5(int num) {
        String hex = "";
        int shang = num;
        int yu = 0;
        while (shang != 0) {

            yu = shang % 2;
            shang = shang / 2;
            hex = yu + hex;
        }
        System.out.println(hex);
    }

    //二进制转 16进制
    public static void f6(int num) {
        int yu = 0;
        int shang = num;

        String ans = "";
        while (shang != 0) {
            yu = shang % 16;
            shang = shang / 16;

            char rs;
            if (yu > 9) {
                rs = (char) ('A' + (yu - 10));
            } else {
                rs = (char) ('0' + (yu - 0));
            }
            ans = rs + ans;


        }
        System.out.println(ans);
    }


}
