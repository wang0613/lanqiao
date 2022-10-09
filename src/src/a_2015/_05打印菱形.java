package src.a_2015;

/*
给出菱形的边长，在控制台上打印出一个菱形来。
为了便于比对空格，我们把空格用句点代替。
当边长为8时，菱形为：

.......*
......*.*
.....*...*
....*.....*
...*.......*
..*.........*
.*...........*
*.............*
.*...........*
..*.........*
...*.......*
....*.....*
.....*...*
......*.*
.......*


public class A
{
    public static void f(int n)
    {
        String s = "*";
        for(int i=0; i<2*n-3; i++) s += ".";
        s += "*";

        String s1 = s + "\n";
        String s2 = "";

        for(int i=0; i<n-1; i++){
            //System.out.println("=>"+s);
            s = "." + _____________________________________ + "*";  //填空
            s1 = s + "\n" + s1;
            s2 += s + "\n";
        }
        System.out.println(s1+s2);
    }

    public static void main(String[] args)
    {
        f(8);
    }
}
 */
public class _05打印菱形 {
    public static void main(String[] args) {

        f(8);
    }

    public static void f(int n) {
        String s = "*";
        for (int i = 0; i < 2 * n - 3; i++) {
            s += ".";
        }
        s += "*";

        String s1 = s + "\n";
        String s2 = "";

        for (int i = 0; i < n - 1; i++) {
//            System.out.println("=>"+s);
            //s被重新复制，需要操作的就是s
            s = "." + s.substring(0,s.length()-3) + "*";  //填空
            s1 = s + "\n" + s1;
            s2 += s + "\n";
        }
        System.out.println(s1 + s2);
    }
}
