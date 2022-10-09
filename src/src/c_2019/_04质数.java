package src.c_2019;

/*
D.质数
【问题描述】

我们知道第一个质数是 2、第二个质数是 3、第三个质数是 5……请你计算 第 2019 个质数是多少？
 */
public class _04质数 {
    public static void main(String[] args) {

        //遍历所有的数，如果层数到达2019，就是质数
        int ctn = 0;
        for (int i = 0; ; i++) {
            if (check(i)) {
                ctn++;
            }
            if (ctn == 2019) {
                System.out.println(i);
                return;
            }

        }


    }

    private static boolean check(int i) {

        //判断是不是质数
        //质数：素数，除了自身，不能为任何数整除
        for (int j = 2; j < i; j++) {

            if (i % j == 0) {
                return false;

            }
        }
        return true;
    }
}
