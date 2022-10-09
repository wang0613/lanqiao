package src.digui.p01;

public class Test1 {


    public static void main(String[] args) {

        /*for (int i = 0; i < 10; i++) {
            System.out.println(i);

        }*/
        f( 9);

    }

//如果没有明显的相似性，需要主动构造(参数等)
    public static void f2(int begin, int end) {
        if (begin > end) return;
        System.out.println(begin);

        f2(begin + 1, end);


    }


    public static void f(int i) {
        if (i > 0)
            f(i - 1);

        //执行完递归 才执行输出语句
        //n = 9 被压栈 先进后出
        System.out.println(i); //  0  1 2 3 4 5  6  7   8   9
    }
}
