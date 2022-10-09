package src;

import java.util.Scanner;

/**
 * 5,10,25,1
 * 15
 * <p>
 * 问题：换钱的方法数
 * 暴力递归法
 */

public class ExchangeMoney {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] str = s.split(",");
        int target = in.nextInt();
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int result = getResult(arr, 0, target);
        System.out.println(result);

    }

    public static int getResult(int[] arr, int index, int target) {
        if (arr.length == 0 || arr == null || target < 0) {
            return 0;
        } else {
            return f(arr, index, target);
        }
    }

    //实现(暴力递归)
    public static int f(int[] arr, int index, int target) {
        // res记录结果数
        int res = 0;
        // 递归终止条件，index是否已经到达数组最后
        // 此时当target为0时，表示此方法可行，res置1
        if (index == arr.length) {
            res = target == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= target; i++) {
                res += f(arr, index + 1, target - arr[index] * i);
            }
        }
        return res;

    }
}
