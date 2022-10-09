package src.p_01位运算;

/*
一个数组中除以一个数出现了一次之外，其他的数字都出现了两次，请写出程序找出这个只出现一次的数字
 */
public class _02找出落单的那个数 {

    public static void main(String[] args) {

        //找出连续不相等的那个数
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 7, 7};

        for (int i = 0; i < arr.length; i+=2) {
            if (arr[i] != arr[i+1]){
                System.out.println(arr[i]);
                break;
            }

        }


    }
}
