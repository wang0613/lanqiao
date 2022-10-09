package src.p_01位运算;

/*
实现一个函数，输入一个整数，输出该数二进制中1的个数
打印二进制中1的个数
 */
public class _03二进制中一的个数 {

    public static void main(String[] args) {
        f(9);
    }

    public static void f(int num) {
        //1：转换为二进制
        String s = Integer.toBinaryString(num);

//        System.out.println(s);
        int count = 0;
        //转换为字符数组，遍历，count++;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count++;
            }

        }

        System.out.println(count);

    }
}
