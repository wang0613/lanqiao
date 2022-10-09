package src.p_02排序;


public class _02希尔排序 {
    public static void main(String[] args) {
        int[] arr = {1, 23, 5, 75, 12, 4};
        shellSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void shellSort(int[] arr) {

        //不断缩小增量，增量 就是 interval
        for (int interval = arr.length / 2; interval > 0; interval--) {

            //做插入排序 步进为interval
            for (int i = interval; i < arr.length; i++) {
                int target = arr[i];
                int j = i - interval;//前一个增量
                while (j > -1 && target < arr[j]) {
                    arr[j + interval] = arr[j];
                    j -= interval;

                }
                arr[j + interval] = target; //和t交换位置
            }


        }

    }
}
