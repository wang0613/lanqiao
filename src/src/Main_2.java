package src;

import java.util.Arrays;

/**
 * 全排列
 */
public class Main_2 {
    public static void main(String[] args) {
        perm(new int[]{1, 2, 3}, 0, 2);
    }

    public static void perm(int[] array, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i <= end; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swap(array, start, i);
                perm(array, start + 1, end);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swap(array, start, i);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
