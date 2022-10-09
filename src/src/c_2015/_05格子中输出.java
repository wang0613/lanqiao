package src.c_2015;

/*
格子中输出
stringInGrid方法会在一个指定大小的格 子中打印指定的字符串。
要求字符串在水平、垂直两个方向上都居中。
如果字符串太长，就截断。
-------------
-           -
-  abcd1234 -
-           -
-------------

如果不能恰好居中，可以稍稍偏左或者偏上一-点。
下面的程序实现这个逻辑，请填写划线 部分缺少的代码。

public static void stringInGrid(int width, int height, String s)
{
	if(s.length()>width-2) s = s.substring(0,width-2);
	System.out.print("+");
	for(int i=0;i<width-2;i++) System.out.print("-");
	System.out.println("+");

	for(int k=1; k<(height-1)/2;k++){
		System.out.print("|");
		for(int i=0;i<width-2;i++) System.out.print(" ");
		System.out.println("|");
	}

	System.out.print("|");

	String ff = _______________________________________________________;  //填空
	System.out.print(String.format(ff,"",s,""));

	System.out.println("|");

	for(int k=(height-1)/2+1; k<height-1; k++){
		System.out.print("|");
		for(int i=0;i<width-2;i++) System.out.print(" ");
		System.out.println("|");
	}

	System.out.print("+");
	for(int i=0;i<width-2;i++) System.out.print("-");
	System.out.println("+");
}
 */
public class _05格子中输出 {

    public static void main(String[] args) {
        stringInGrid(20, 6, "abcd1234");

    }

    public static void stringInGrid(int width, int height, String s) {
        if (s.length() > width - 2) s = s.substring(0, width - 2);
        System.out.print("+");
        for (int i = 0; i < width - 2; i++) System.out.print("-");
        System.out.println("+");

        for (int k = 1; k < (height - 1) / 2; k++) {
            System.out.print("|");
            for (int i = 0; i < width - 2; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("|");

        //使用指定的格式字符串和参数返回一个格式化字符串。
        //ff就是格式 %占位
        //%+后后面的空格数 宽度-2(两个||)-字符串的长度/2
        String ff = "%" + (width - 2 - s.length()) / 2 + "s%s%" + (width - 2 - s.length() - ((width - 2 - s.length()) / 2)) + "s";  //填空
        System.out.print(String.format(ff, "", s, ""));

        System.out.println("|");

        for (int k = (height - 1) / 2 + 1; k < height - 1; k++) {
            System.out.print("|");
            for (int i = 0; i < width - 2; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < width - 2; i++) System.out.print("-");
        System.out.println("+");
    }

}
