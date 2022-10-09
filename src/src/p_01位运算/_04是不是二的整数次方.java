package src.p_01位运算;

/*
用一条语句判断是不是2的整数次方

2^0 2^1

2的整数次方特点： 它的二级制数某一位上是1其他数字是0
 */
public class _04是不是二的整数次方 {
    public static void main(String[] args) {

        int n = 8;
        //n-1 & n == 0 就是
        //8-1 & 8
        //0111 & 1000 =

        if (((n - 1) & n) == 0) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }


    }
}
