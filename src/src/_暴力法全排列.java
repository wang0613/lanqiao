package src;

import java.util.*;

/**
 * 实现 ABC的全排列
 */
public class _暴力法全排列 {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");


//        System.out.println(f(list));

//        String[] arr = {"A", "B", "C"};
        int[] arr = {1,2,3};
        perm(arr, 0,2);

    }

    public static Set<String> f(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                String b = list.get(j);
                for (int k = 0; k < list.size(); k++) {
                    String c = list.get(k);

                    if (!a.equals(b) && !a.equals(c) && !b.equals(c)) {
                        String str = a + b + c;
                        set.add(str);
                    }

                }

            }

        }
        return set;

    }

    //全排列
    public static void f2(String[] arr, int k) {

        if (k == arr.length) {
            System.out.println(Arrays.toString(arr));
        }

        for (int i = k; i < arr.length; i++) {
            String t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            f2(arr, k + 1);


            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

        }

    }

    //全排列
    public static void perm(int[] array, int start, int end) {
        if (start == end) {
//            System.out.println(Arrays.toString(array));
            System.out.println(toInt(array, 0, 3));
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

    public static int toInt(int[] array, int start, int end) {
        int t = 1;
        int ans = 0;
        for (int i = end - 1; i >= start; i--) {
            ans += t * array[i];

            t *= 10;
        }
        return ans;

    }
}
