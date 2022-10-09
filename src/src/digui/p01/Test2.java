package src.digui.p01;

public class Test2 {


    public static void main(String[] args) {
        int[] a = {2, 9, 3, 5, 12, 7};

        int sum = f2(a, a.length-1);
//        int sum = f3(a, 0, a.length - 1);

        System.out.println(sum);
    }


    //求a数据中，从begin开始到结束的元素和
    public static int f(int[] a, int begin) {
        //踢皮球 {. [.[....]]}     {[...] [...]}

        if (begin == a.length) return 0;

        return a[begin] + f(a, begin + 1);

    }

    public static int f2(int[] a, int end) {
        //踢皮球 {[[].].}


        if (end < 0) return 0; //到头了

        int x = f2(a, end - 1);

        return x + a[end];

    }

    //折分法
    public static int f3(int[] a, int begin, int end) {
        //踢皮球 {[],[]}
/*
    如数组{1,2}，mid=(0+1)/2=0, 即mid=begin,  此时需返回这两个值的和；
    如数组{1} ,此时begin=end,需返回该值，因为这时的a[begin] 与a[end]是同一个值。
*/

//        [0-mid) [mid-end)
        if (begin == end) //参考举例解释
            return a[begin];

        int mid = (begin + end) / 2; //mid记录数组中间位置 ，用于折半

        if (mid == begin)   //参考举例解释
            return a[begin] + a[end];

        return f3(a, begin, mid - 1) + f3(a, mid, end);
        //分别表示左区间（左闭右开），右区间（双闭）


    }

    public static int addAll(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

        }
        return sum;

    }


    //递归累加 1.... 100
    public static int getAllSum(int n) {
        if (n == 1) return 1;
        //100 + 99
        return getAllSum(n - 1) + n;
    }

}
