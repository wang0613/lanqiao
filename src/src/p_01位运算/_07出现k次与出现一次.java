package src.p_01位运算;

/**
 * 数组中只有一个数出现一次，其他的数都出现了K次，请输出只出现一次的数
 * <p>
 * 思路：
 * 2个相同的二进制位数做不进位加法，结果为0
 * 10个相同的二进制位数做不进位加法，结果为0
 * K个相同的二进制位数做不进位加法，结果也为0
 */

public class _07出现k次与出现一次 {
    public static void main(String[] args) {

        int[] arr = {2, 2,4, 7, 7, 7, 3, 3, 3, 6, 6, 6, 0, 0, 0};
        int len = arr.length;
        char[][] kRadix = new char[len][];
        int k = 3;
        int maxLen = 0;
        //转换为k进制字符数组
        for (int i = 0; i < len; i++) {
            //求每个数字的三级制字符串并反转
            kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            if (kRadix[i].length > maxLen) {
                maxLen = kRadix[i].length;
            }
        }
        //反转后 进行不进位的加法
        int[] resArr = new int[maxLen];
        for (int i = 0; i < len; i++) { //遍历每一个行
            for (int j = 0; j < maxLen; j++) { //遍历每一个列
                if (j >= kRadix[i].length)
                    resArr[j] += 0;
                else
                    resArr[j] += (kRadix[i][j] - '0');
            }

        }
        //将最后的三进制结果 转换回来
        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            res += (resArr[i] % k) * (int) (Math.pow(k, i));


        }
        System.out.println(res);


    }
}
