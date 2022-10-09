package src.p_01位运算;


import java.util.Random;

public class _01位运算 {
    public static void main(String[] args) {

        /*System.out.println(1 << 35); // 8
        System.out.println(1 << 3); //8

        System.out.println(Integer.toBinaryString(21));//10101

        System.out.println(200 & 1); //判断奇偶数   0  1
        System.out.println(10 | 2);

        //异或 可以理解为不进位加法   1+1=0  1+0 =1  0+0 = 0 */
        //异或：将两个条件进行转换，转换成二进制后在进行运算
//        System.out.println(1 ^ 1); //1

        getInt();

    }

    //如何找出成对的那个数
    public static void getInt() {
        int N = 1001;
        int[] arr = new int[N];
        //添加数据到数组  9个 保留最后由为
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = i + 1;

        }
        //最后一个数，是随机数  1-10 [) 左闭右开
        arr[arr.length - 1] = new Random().nextInt(N - 1) + 1;  //随机产生0到执行位置的int数字
        //随机下标 0-10
        int index = new Random().nextInt(N);
        //随机下标和最后调换位置
        swap(arr, index, arr.length - 1);

        for (int i : arr) {
            System.out.print(i+" ");
        }

        int x = 0;
        for (int i = 1; i <= N - 1; i++) {
            x = (x ^ i); //异或  i
            
        }
        for (int i = 0; i < N; i++) {
            x = x^arr[i];
            
        }
        System.out.println();
        System.out.println(x);


        System.out.println("-------------------------");
        //2：使用辅助空间
        int[] helper = new int[N];
        for (int i = 0; i < N; i++) {
             helper[arr[i]] ++;
            
        }
        for (int i = 0; i < N; i++) {
            if (helper[i] == 2){
                System.out.println(i);
            }

        }


    }

    //交换执行位置索引的值
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
